package com.smartjava.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjava.demo.model.User;
import com.smartjava.demo.resultresponse.ResultRespone;
import com.smartjava.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public ResultRespone create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping("/byId/{id}")
	public ResultRespone getById(@PathVariable(value = "id") int id) {
		return userService.getById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResultRespone update(@PathVariable(value = "id") int id,@RequestBody User user) {
		return userService.update(id,user);
	}

}
