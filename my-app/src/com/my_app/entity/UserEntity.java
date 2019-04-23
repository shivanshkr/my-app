package com.my_app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "User_Detail")
@GenericGenerator(name="idGen",strategy="increment")
public class UserEntity {
	@Id
	@GeneratedValue(generator = "idGen")
	@Column(name = "CUSTOMER_ID")
	private Integer customerId;
	@Column(unique = true)
	private String name;
	private String username;
	private String password;
	@CreationTimestamp
	@Column(name = "CREATED_TIMESTAMP")
	private LocalDateTime createdTimeStamp;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public LocalDateTime getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	
}
