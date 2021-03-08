package com.login.demo.controller;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.demo.model.AuthRequest;
import com.login.demo.util.JWTUtil;

@RestController
//@RequestMapping("/api/v1/")
public class UserController {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome() {
		return "Hello JWT";
		}
	
	
	@PostMapping("/authenticate")
	public String generateTokenString( @RequestBody AuthRequest authRequest) throws Exception {
	try {
				
		authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		}
			
	 catch (Exception e) {
		throw  new Exception("Invalid Username or Password");
		}
				
	 return jwtUtil.generateToken(authRequest.getUserName());
						
		
	}  
} 

