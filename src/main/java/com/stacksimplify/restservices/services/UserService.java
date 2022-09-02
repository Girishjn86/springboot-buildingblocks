package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);		
	}
	
	public User updateUserById(Long id, User user) {		
		user.setId(id);
		return userRepository.save(user);
	}
	public String deleteUserById(Long id) {
		String result = "Not existed";
		if(userRepository.findById(id).isPresent()) {
		 userRepository.deleteById(id);
		 result = "deleted";
		}
		return result;
	}
	public User getUserByUsername(String uName) {
		return userRepository.findByUsername(uName);
	}
}
