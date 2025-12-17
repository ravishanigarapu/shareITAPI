package com.jntuh.college.controller;

import java.util.*;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	@PostMapping("/validate")
	@CrossOrigin
	public boolean validateUserCredentials(@RequestBody String req) {
		
		boolean validated = false;
		JSONObject jsonObject = new JSONObject(req);
		String uername = jsonObject.get("username").toString();
		System.out.println("---------------Entered--------------"+ req);
		List<String> loginusers = new ArrayList<>();
		loginusers.add("Ravi");
		loginusers.add("Helen");
		loginusers.add("Rohi");
		if(null != uername && loginusers.contains(uername)) {
			validated =true;
		}
		return validated;
	}
}
