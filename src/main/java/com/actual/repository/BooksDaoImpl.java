/*package com.actual.repository;

import com.actual.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Repository
public class BooksDaoImpl extends JdbcDaoSupport implements BooksDao{

	private final DataSource ds;

	@Autowired
	public BooksDaoImpl(DataSource dataSource) {
		this.ds = dataSource;
	}

	@Override
	//@Qualifier("com.actual.config.BatchConfig.dataSource")
	public Book findByTitle(String title) {
		String h2 = "SELECT * FROM Books book WHERE book.title LIKE :title";
		return this.getJdbcTemplate().queryForObject(h2, Book.class);
	}
}*/
