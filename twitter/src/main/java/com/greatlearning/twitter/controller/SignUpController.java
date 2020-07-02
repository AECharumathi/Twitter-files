package com.greatlearning.twitter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.greatlearning.twitter.model.User;
import com.greatlearning.twitter.service.UserService;

@RestController
@RequestMapping("/api/signup")
public class SignUpController {
	
	private HashMap<String, Boolean> signupStatus;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Boolean> signupUser(@RequestBody User user) {
		signupStatus = new HashMap<String, Boolean>();
		try {
			this.userService.saveUser(user);
			signupStatus.put("status", true);
		} catch(Exception x) {
			signupStatus.put("status", false);
		}
		return signupStatus;
	}
}
