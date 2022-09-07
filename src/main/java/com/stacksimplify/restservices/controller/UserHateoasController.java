package com.stacksimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.Exceptions.UserNotFoundException;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.services.UserService;

@RestController
@Validated
@RequestMapping("/hateoas/users")
public class UserHateoasController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.get();
		Long userId = user.getUserId();
		Link selflink = WebMvcLinkBuilder.linkTo(this.getClass()).slash(userId).withSelfRel();
		user.add(selflink);

		return user;
	}
}
