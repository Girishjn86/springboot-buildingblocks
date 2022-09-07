package com.stacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.hateoas.RepresentationModel;

/*import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
*/
@Entity
@Table(name="users")
public class User extends RepresentationModel{
	@Id
	@GeneratedValue
	private Long userId;
	@NotEmpty(message ="should Not be empty")
	@Column(name="USER_NAME", length=50,nullable=false,unique = true)	
	private String username;
	@Size(min=2, message="minimum 2 characters")
	@Column(name="FIRST_NAME", length=50,nullable=false)
	private String firstName;
	@Column(name="LAST_NAME", length=50,nullable=false)
	private String lastName;
	@Column(name="EMAIL_ADDRESS", length=50,nullable=false)
	private String email;
	@Column(name="Role", length=50,nullable=false)
	private String role;
	@Column(name="SSN", length=50,nullable=false,unique=true)
	private String ssn;
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	public User() {
	}
	public User(Long userId, String username, String firstName, String lastName, String email, String role, String ssn) {
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
}
