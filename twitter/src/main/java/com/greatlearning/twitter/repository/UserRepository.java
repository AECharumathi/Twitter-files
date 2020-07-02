package com.greatlearning.twitter.repository;

import com.greatlearning.twitter.model.User;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserHandle(String userHandle);

	User findById(long id);

	@Query(value="From User where email=?1 and encrypted_password=?2")
	User findByEmailAndEncryptedPassword(String email, String password);

	@Modifying
	@Query(value = "insert into users_followers (followers,following) values (?1,?2)", nativeQuery = true)
	@Transactional
	void findByFollowersAndFollowing(long fromId, long toId);
}