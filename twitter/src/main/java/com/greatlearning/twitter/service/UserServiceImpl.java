package com.greatlearning.twitter.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.twitter.repository.UserRepository;
import com.greatlearning.twitter.model.Follow;
import com.greatlearning.twitter.model.Login;
import com.greatlearning.twitter.model.Tweet;
import com.greatlearning.twitter.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
    	return this.userRepository.save(user);
    }

    @Override
    public Set<Tweet> getAllTweetsByUserId(long userId) {
       User user = this.userRepository.findById(userId);
       return user.getTweets();
    }

    public void updateUser(User user){
        this.userRepository.save(user);
    }

    @Override
    public void addTweet(long userId, Tweet tweet) {
        User user = this.userRepository.findById(userId);
        user.addTweet(tweet);
    }

    @Override
    public Set<User> getFollowersByUserId(long userId) {
        User user = this.userRepository.findById(userId);
        return user.getFollowers();
    }

    @Override
    public Set<User> getFollowingByUserId(long userId) {
        User user = this.userRepository.findById(userId);
       return user.getFollowing();
    }

    @Override
    public Set<Tweet> getTweetsByFollowerId(long followerId) {
    	Set<Tweet> tweets =  this.getAllTweetsByUserId(followerId);
        return tweets;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public List<User> listAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return this.userRepository.findById(id);
    }

	@Override
	public User findByUsername(String userHandle) {
		return this.userRepository.findByUserHandle(userHandle);
	}

	@Override
	public User loginUser(Login user) {
		return this.userRepository.findByEmailAndEncryptedPassword(user.getemail(),user.getEncryptedPassword());
	}

	@Override
	public void follow(Follow follow) {
		this.userRepository.findByFollowersAndFollowing(follow.getFromId(), follow.getToId());
	}
}