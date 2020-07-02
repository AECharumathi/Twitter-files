package com.greatlearning.twitter.controller;

import com.greatlearning.twitter.model.User;
import com.greatlearning.twitter.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    @ApiOperation(value = "Fetch all users", notes = "API to fetch all the users")
    public List<User> getAllUsers() {
        logger.info("-- Came inside the getALlUsers method --");
        return this.userService.listAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Fetch users details for the given id", notes = "API to fetch the user details")
    public User getUserById(@ApiParam(value = "id", example = "34", required = true) @PathVariable("id")long id){
        return this.userService.findById(id);
    }

    @PostMapping(value = "/", consumes = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
    	User saveUser = this.userService.saveUser(user);
        return saveUser;
    }
    
    @GetMapping("/{id}/followers")
    public List<User> getFollowersByUserId(@PathVariable("id") long id){
        return this.userService.listAll();
    }

    @PostMapping("/follow/")
	public String follow(User user) {
		return "success";
	}
    
    
    
}