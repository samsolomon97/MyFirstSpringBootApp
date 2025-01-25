package com.example.MyFirstSpringBootApp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyFirstSpringBootApp.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

//	@GetMapping
//	public String getUsers() {
//		return "Here are the users";
//	}
	
	@GetMapping
	public List<User> getUsers() {
		return Arrays.asList(new User(1L, "John", "john@gmail.com"), 
				new User(1L, "Sam", "sam@gmail.com"));
	}
}
