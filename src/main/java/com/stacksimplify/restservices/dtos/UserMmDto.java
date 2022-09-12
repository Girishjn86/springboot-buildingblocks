package com.stacksimplify.restservices.dtos;

import java.util.List;

import com.stacksimplify.restservices.entities.Order;

public class UserMmDto {
	private Long Id;
	private String username;
	private List<Order> orders;
	public Long getUserId() {
		return Id;
	}
	public void setUserId(Long userId) {
		this.Id = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
