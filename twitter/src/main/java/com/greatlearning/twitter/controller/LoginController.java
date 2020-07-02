package com.greatlearning.twitter.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import com.greatlearning.twitter.model.Login;
import com.greatlearning.twitter.model.User;
import com.greatlearning.twitter.service.UserService;


@RestController
@RequestMapping("/api")
public class LoginController {
    
	@Autowired
    private UserService userService;
	
	//private HashMap<String, String> loginStatus;
	
	@PostMapping(value = "/login", consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})

	@ResponseStatus(HttpStatus.OK)
	public Optional<User> loginUser(@RequestBody Login login) {
		Optional<User> loginUser =  Optional.ofNullable(this.userService.loginUser(login));
		//loginStatus = new HashMap<String, String>();
		
		
		if(loginUser.isPresent()) {
			return this.userService.;
		}
		return loginUser;
	}

	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@Valid Login login, BindingResult result,Model model,RedirectAttributes redirectAttributes) {
		Optional<User> loginUser =  Optional.ofNullable(this.userService.loginUser(login));
		if(loginUser.isPresent()) {
			model.addAttribute("login",login);
      //Do the Registration logic and then redirect to home page without using action for home page
			redirectAttributes.addFlashAttribute("login", login);
			return "redirect:/home";
		}
		else
			return "false";
    }
    */
}

