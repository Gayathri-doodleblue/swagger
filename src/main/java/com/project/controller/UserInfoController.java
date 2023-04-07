package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.UserInfo;
import com.project.service.UserInfoService;



@RestController
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	@PostMapping("/addUser")
	public UserInfo addUser(@RequestBody UserInfo userInfo)
	{
		return userInfoService.addLonginDetails(userInfo);
	}
	
	@GetMapping("/signup")
	 @PreAuthorize("hasAuthority('ROLE_USER')")
	 public Optional<UserInfo> logInUser() {
	  SecurityContext securityContext = SecurityContextHolder.getContext();
	  Authentication authentication = securityContext.getAuthentication();
	  String username = authentication.getName();
	  return userInfoService.getUser(username);
	 }
	
	
}
