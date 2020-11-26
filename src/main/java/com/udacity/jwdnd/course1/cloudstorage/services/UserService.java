package com.udacity.jwdnd.course1.cloudstorage.services;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;


@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HashService hashService;

	public boolean isUsernameAvailable(String username) {
		User user = userMapper.getUser(username);
		if(user==null)return true;
		else return false;
	}
	
	public User getUser(String username) {
		return userMapper.getUser(username);
	}

	public int createUser(User newUser) {
		SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(newUser.getPassword(), encodedSalt);
        return userMapper.insert(new User(null, newUser.getUsername(), encodedSalt, hashedPassword, newUser.getFirstname(), newUser.getLastname()));
	}
}
