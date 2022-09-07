package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.Exceptions.UserExistsException;
import com.stacksimplify.restservices.Exceptions.UserNotFoundException;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(User user) throws UserExistsException {
		if(userRepository.findByUsername(user.getUsername()) != null) { 	
			throw new UserExistsException("User exist");
		}else {
			return userRepository.save(user);
		}
		
	}

	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not exist");
		}
		return user;
	}

	public User updateUserById(Long id, User user) throws UserNotFoundException {
		if(userRepository.findById(id).isPresent()) { 
			user.setUserId(id);
			return userRepository.save(user);
		}else {
			throw new UserNotFoundException("User Not exist");
		}
	}

	public String deleteUserById(Long id) {
		if (userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);			
		}else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not present");
		}
		return "deleted";
	}

	public User getUserByUsername(String uName) {
		return userRepository.findByUsername(uName);
	}
}
