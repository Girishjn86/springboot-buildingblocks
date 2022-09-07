package com.stacksimplify.restservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.Exceptions.UserNotFoundException;
import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class OrderController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("User not found");
		return user.get().getOrders();
	}
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userId);
		if(!optionalUser.isPresent())
			throw new UserNotFoundException("User Not Found");
		User user = optionalUser.get();
		order.setUser(user);
		return orderRepository.save(order);
		
	}
	
	@GetMapping("/{userId}/orders/{orderId}")
	public Order getOrderByOrderId(@PathVariable Long userId,@PathVariable Long orderId) throws UserNotFoundException {
		System.out.println("in");
		Optional<User> optionalUser = userRepository.findById(userId);
		
		  if(!optionalUser.isPresent()) 
			  throw new UserNotFoundException("User Not Found");
		 
		User user = optionalUser.get();
		List<Order> orders = user.getOrders();
		System.out.println("outside");
		for(Order o:orders) {
			if(o.getOrderId().compareTo(orderId) == 0) {
				
				System.out.println("Condition met");
				return o;
			}
		}
		return null;
		
		
	}
}
