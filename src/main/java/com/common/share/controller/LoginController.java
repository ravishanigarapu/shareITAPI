package com.common.share.controller;

import java.util.*;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.share.dto.LoginRequest;
import com.common.share.dto.User;
import com.common.share.service.LoginService;
import com.common.share.service.RegistrationService;

@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	LoginService loginService;
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
	    try {
	        User student = loginService.login(
	                request.getUserName(),
	                request.getPassword()
	        );

	        return ResponseEntity.ok(student);

	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .body(e.getMessage());
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Login failed");
	    }
	}
}
