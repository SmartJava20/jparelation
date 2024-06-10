package com.smartjava.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartjava.demo.model.Profile;
import com.smartjava.demo.model.User;
import com.smartjava.demo.resultresponse.ResultRespone;
import com.smartjava.demo.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/save")
	public ResultRespone create(@RequestBody Profile profile) {
		return profileService.create(profile);
	}
	
	@GetMapping("/byId/{id}")
	public ResultRespone getById(@PathVariable(value = "id") int id) {
		return profileService.getById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResultRespone update(@PathVariable(value = "id") int id,@RequestBody Profile profile) {
		return profileService.update(id,profile);
	}

}
