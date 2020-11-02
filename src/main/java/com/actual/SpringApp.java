package com.actual;

//import com.actual.repository.BookRepository;
import org.h2.tools.Server;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

@SpringBootApplication
		/*(exclude = {
		DataSourceAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})*/
@Component
public class SpringApp {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}

	//создание потока выполнения
	@PostConstruct
	public void perform() throws Exception {
		JobParameters parameters = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(job, parameters);
	}

	//предоставление порта для взаимодействия с H2 через tcp-порт
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "8095");
	}
}
