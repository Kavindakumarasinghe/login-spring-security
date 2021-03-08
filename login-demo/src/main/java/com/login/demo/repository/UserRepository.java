package com.login.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);
}
 