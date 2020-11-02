package com.actual.config;

import com.actual.model.Book;
import org.springframework.batch.item.ItemProcessor;

public class DBLogProcessor implements ItemProcessor<Book, Book> {

	public Book process(Book Book) throws Exception {
		System.out.println("Inserting book : " + Book);
		return Book;
	}
}
