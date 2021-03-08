package com.login.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.demo.model.User;
import com.login.demo.repository.UserRepository;

@Service

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
  @Override	
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	  User user = userRepository.findByUserName(username);
	  return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
  }
}
