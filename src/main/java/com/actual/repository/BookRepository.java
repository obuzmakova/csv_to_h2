/*package com.actual.repository;

import com.actual.config.BatchConfig;
import com.actual.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//@Component
@Repository
//@Conditional(BatchConfig.class)
public interface BookRepository extends CrudRepository<Book, Long> {

	Optional<Book> findByTitle(String title);
	//Optional<Book> findByTitle(String title);

	//@Query("SELECT DISTINCT book FROM Book book WHERE book.title LIKE :title%")
	//Collection<Book> findByTitle(@Param("title") String title);

	//List<Book> findByTitle(String title);
}*/
