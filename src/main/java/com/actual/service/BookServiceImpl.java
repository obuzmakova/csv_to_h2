/*package com.actual.service;

//import com.actual.repository.BookElasticRepository;
import com.actual.model.Book;
//import com.actual.repository.BookElasticRepository;
import com.actual.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Optional<Book> findByTitle(String title) {
		return bookRepository.findByTitle(title);
	}*/

	/*public List getAllBooks() {
		List books = new ArrayList<>();
		bookRepository.findAll();
		return books;
	}*/

	/*public Optional getBook(Long id) {
		return bookRepository.findById(id);
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Long id, Book book) {
		bookRepository.save(book);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}*/

//}
