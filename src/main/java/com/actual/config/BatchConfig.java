package com.actual.config;

import com.actual.model.Book;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	/*@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try {
			context.getClassLoader()
					.loadClass("javax.sql.DataSource");
			return true;
		} catch (Exception e) {
			return false;
		}
	}*/

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Value("classPath:/input/books")
	private Resource inputResource;

	@Bean
	// фабрика автоматически устанавливает JobRepository
	public Job readCSVFileJob() {
		return jobBuilderFactory
				.get("readCSVFileJob")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory
				.get("step")
				//соответствует ItemReader<Book>, ItemWriter<Book>
				.<Book, Book>chunk(5)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public ItemProcessor<Book, Book> processor () {
		return new DBLogProcessor();
	}

	@Bean
	// читает строки из setResource - в моем случае файл csv
	public FlatFileItemReader<Book> reader() {
		FlatFileItemReader<Book> itemReader = new FlatFileItemReader<>();
		// преобразует строки в объекты, представляющие элемент
		itemReader.setLineMapper(lineMapper());
		// кол-во строк, которое нужно пропустить вначале файла
		itemReader.setLinesToSkip(1);
		itemReader.setResource(inputResource);
		return itemReader;
	}

	@Bean (name = "dataSource")
	// здесь можем определить тип источника данных (MySql, Oracle и др.)
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();

		return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/schema-drop-h2.sql")
				.addScript("classpath:org/springframework/batch/core/schema-h2.sql")
				.addScript("classpath:books.sql")
				.setType(EmbeddedDatabaseType.H2)
				.build();
	}

	@Bean
	public JdbcBatchItemWriter<Book> writer() {
		// интеграция источника данных и объекта ItemWriter установит jdbc-соединение
		// оператор sql подготовит пакетное действие, кот.мы хотим выполнить в БД
		JdbcBatchItemWriter<Book> itemWriter = new JdbcBatchItemWriter<>();

		itemWriter.setDataSource(dataSource());
		itemWriter.setSql("INSERT INTO BOOKS ( ID,ANNOTATION,AUTHOR,TITLE,YEAR) VALUES ( :id, :annotation, :author, :title, :year )");
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return itemWriter;
	}

	@Bean
	// для сопоставления строк с объектами домена
	public LineMapper<Book> lineMapper() {
		DefaultLineMapper<Book> lineMapper = new DefaultLineMapper<>();
		// DelimeterLineTokenizer потому что использую csv
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		BeanWrapperFieldSetMapper<Book> fieldSetMapper = new BeanWrapperFieldSetMapper<>();

		lineTokenizer.setNames(new String[]{"id", "annotation", "author", "title", "year" });
		lineTokenizer.setIncludedFields(new int[]{0, 1, 2, 3, 4});
		fieldSetMapper.setTargetType(Book.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		// для отображения данных, полученных в FieldSet в объект
		lineMapper.setFieldSetMapper(fieldSetMapper);

		return lineMapper;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
