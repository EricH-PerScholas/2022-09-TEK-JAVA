package com.teksystems.springboot.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teksystems.springboot.database.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {

}
