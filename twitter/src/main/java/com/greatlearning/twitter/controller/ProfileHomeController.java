package com.greatlearning.twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ProfileHomeController {
	
	@RequestMapping(value = "/home")
	 public String home() {
        return "home";
    }
	
}
