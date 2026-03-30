package com.common.share.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.share.dto.User;
import com.common.share.service.RegistrationService;

@RestController
@RequestMapping("/user")
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;

	@PostMapping("/save")
	public ResponseEntity<?> saveStudent(@RequestBody User user) {
	    try {
	        User savedUser = registrationService.saveUser(user);
	        return ResponseEntity.ok(savedUser); // ✅ ID INCLUDED
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Something went wrong while saving student");
	    }
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudents() {
	    try {
	        List<User> users = registrationService.getAllStudents();

	        if (users.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NO_CONTENT)
	                    .body("No students found");
	        }

	        return ResponseEntity.ok(users);

	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Something went wrong while fetching students");
	    }
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Long id) {
	    try {
	        Optional<User> user = registrationService.getStudentById(id);

	        if (user.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body("Student not found with id: " + id);
	        }

	        return ResponseEntity.ok(user.get());

	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Error while fetching student");
	    }
	}
}
