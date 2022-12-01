package com.teksystems.springboot.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksystems.springboot.database.entity.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
	
	// this will return all records in the user_roles table for a userId
	public List<UserRole> findByUserId(Integer userId);
}
