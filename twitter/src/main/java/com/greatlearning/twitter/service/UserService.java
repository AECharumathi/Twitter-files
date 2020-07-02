package com.greatlearning.twitter.service;

import java.util.List;
import java.util.Set;

import com.greatlearning.twitter.model.Follow;
import com.greatlearning.twitter.model.Login;
import com.greatlearning.twitter.model.Tweet;
import com.greatlearning.twitter.model.User;

public interface UserService {

    User saveUser(User user);

    Set<Tweet> getAllTweetsByUserId(long userId);

    void addTweet(long userId, Tweet tweet);

    Set<User> getFollowersByUserId(long userId);

    Set<User> getFollowingByUserId(long userId);

    Set<Tweet> getTweetsByFollowerId(long follwerId);

    List<User> getAllUsers();

    List<User> listAll();

    User findById(long id);

	User findByUsername(String userHandle);
	
	User loginUser(Login user);

	void follow(Follow follow);
}