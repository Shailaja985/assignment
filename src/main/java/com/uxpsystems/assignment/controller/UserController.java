package com.uxpsystems.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.domain.User;
import com.uxpsystems.assignment.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		User user = userService.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User user) throws Exception {
		user.setId(0);
		User userCreated = userService.save(user);
		return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
		User userUpdated = userService.save(user);
		return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteEmploye(@PathVariable long id) {
		userService.deleteByID(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
