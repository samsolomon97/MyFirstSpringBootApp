package com.example.MyFirstSpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyFirstSpringBootApp.Exception.ResourceNotFound;
import com.example.MyFirstSpringBootApp.model.User;
import com.example.MyFirstSpringBootApp.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("ID not found"));
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable Long id, @RequestBody User user) {
		User userData =  userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("ID not found"));
		userData.setName(user.getName());
		userData.setEmail(user.getEmail());
		return userRepo.save(userData);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
		User userData =  userRepo.findById(id).orElseThrow(() -> new ResourceNotFound("ID not found"));
		userRepo.delete(userData);
		return ResponseEntity.ok().build();
	}
}
