package com.greatlearning.twitter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HomeController {

	@RequestMapping(value = "/index")
    public String index() {
        return "index";
    }	
}
