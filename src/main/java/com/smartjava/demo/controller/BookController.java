package com.smartjava.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjava.demo.model.Author;
import com.smartjava.demo.model.Book;
import com.smartjava.demo.resultresponse.ResultRespone;
import com.smartjava.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/save")
	public ResultRespone create(@RequestBody Book book) {
		return bookService.create(book);
	}

	@GetMapping
	public ResultRespone findAll() {
		return bookService.findAll();
	}

}
