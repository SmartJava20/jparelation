package com.smartjava.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjava.demo.model.Author;
import com.smartjava.demo.resultresponse.ResultRespone;
import com.smartjava.demo.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResultRespone findAll() {
		return authorService.findAll();
	}
	
	@PostMapping("/save")
	public ResultRespone create(@RequestBody Author author) {
		return authorService.create(author);
	}

}
