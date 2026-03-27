package com.common.share.controller;

import java.util.*;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.share.dto.Student;

@RestController
@RequestMapping("/validate")
public class LoginController {
	private List<Student> students = new ArrayList<>();
	@PostMapping("/login")
	@CrossOrigin
	public boolean validateUserCredentials(@RequestBody String req) {
		
		boolean validated = false;
		JSONObject jsonObject = new JSONObject(req);
		String username = jsonObject.get("username").toString();
		System.out.println("---------------Entered--------------"+ req);
		for (Student student : students) {
			if(student.getFirstName().equalsIgnoreCase(username)) {
				validated = true;
			}
		}
		
		return validated;
	}
	
	
	@PostMapping("/save")
	@CrossOrigin
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {

		try {
			if (student == null || student.getFirstName() == null || student.getFirstName().isEmpty()) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student name is required");
			}

			students.add(student);
			return ResponseEntity.status(HttpStatus.OK).body(student);

		} catch (Exception e) {
			// 🔴 500 - Internal Server Error
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Something went wrong while saving student");
		}
	}
}
