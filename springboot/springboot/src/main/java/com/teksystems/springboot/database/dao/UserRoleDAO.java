package com.teksystems.springboot.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksystems.springboot.database.entity.UserRole;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
	

}
