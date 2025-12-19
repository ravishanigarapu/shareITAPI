package com.jntuh.college.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jntuh.college.dto.Student;

@RestController
@RequestMapping("/student")
public class RegistrationController {
	private List<Student> students = new ArrayList<>();
	@PostMapping("/save")
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
