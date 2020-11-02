/*package com.actual.controller;

import com.actual.model.Book;
//import com.actual.service.BookService;
import com.actual.repository.BooksDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BooksDaoImpl booksDaoImpl;

	@RequestMapping(value = "/title", method = RequestMethod.GET)
	public @ResponseBody
	Book findByTitle(String title) {
		return booksDaoImpl.findByTitle(title);
	}
}*/
