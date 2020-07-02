package com.greatlearning.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@ToString
@EqualsAndHashCode(exclude = {"firstName","lastName","location"})
@Table(name="users")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1000L;

	@Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    @JsonProperty("user_name")
    private String userHandle;
    
    @Column(unique = true, nullable = false)
    @JsonProperty("user_email")
    private String email;

    @Column(nullable = false, length = 60)
    //@JsonIgnore
    @JsonProperty("user_pass")
    private String encryptedPassword;

    @Column(nullable = false, length = 26)
    @JsonProperty("first_name")
    private String firstName;

    @Column(nullable = false, length = 26)
    @JsonProperty("last_name")
    private String lastName;

    @Column(nullable = false, length = 52)
    @JsonProperty("full_name")
    private String fullName;
    
    @Column
    private Date dateOfBirth;
    
    @Column(length = 31)
    private String country;

    @Column(length = 31)
    private String location;

    @Column(length = 63)
    private String postalAddress;

    @Column(length = 10)
    private String postalCode;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonIgnore
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date modified;
    
    @Getter(AccessLevel.NONE)
    @JsonProperty("status")
	private boolean enabled = true;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tweet> tweets;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="users_followers",
            joinColumns = @JoinColumn(name = "followers"),
            inverseJoinColumns = @JoinColumn(name = "following"))

    private Set<User> followers = new HashSet<>();


    @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> following = new HashSet<>();


    public User(){

    }

    public User(String userHandle, String email, String encryptedPassword, String firstName, String lastName, Date dateOfBirth, String fullName) {
        super();
        this.userHandle = userHandle;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.created = new Date();
        this.fullName= fullName;
    }
    
    public String getUserHandle() {
		return userHandle;
	}

	public void setUserHandle(String userHandle) {
		this.userHandle = userHandle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addTweet(Tweet tweet){
        this.getTweets().add(tweet);
        tweet.setUser(this);
    }

    public Set<Tweet> getTweets() {
		return this.tweets;
	}

	public void addFollower(User follower){
        follower.getFollowing().add(this);
        this.getFollowers().add(follower);
    }

	public Set<User> getFollowing() {
		return this.following;
	}

	public Set<User> getFollowers() {
		return this.followers;
	}
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getPasswordConfirm() {
        return encryptedPassword;
    }

    public void setPasswordConfirm(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
	
}