package com.teksystems.springboot.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksystems.springboot.database.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
	
	public User findById(Integer id);
}
