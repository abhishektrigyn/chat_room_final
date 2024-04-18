package com.example.messagecrud.repo;

import org.springframework.data.jpa.repository.Query;

import com.example.messagecrud.model.User;

public interface CommonRepoCustom {
	@Query("FROM User u WHERE u.username  = ?1 AND u.password=?2")
    User validateUser(String username,String password);
	
	@Query("FROM User u WHERE u.username  = ?1 ")
    User checkUser(String username);
	
}
