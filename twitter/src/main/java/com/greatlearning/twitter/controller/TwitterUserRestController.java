package com.greatlearning.twitter.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.twitter.service.UserService;

import com.greatlearning.twitter.model.User;

@RestController
@RequestMapping("/api/user")
public class TwitterUserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public List<User> listAllUsers() {
		return this.userService.getAllUsers();
	}
}
