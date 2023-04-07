package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.model.UserInfo;
import com.project.repository.UserInfoRepository;



@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	@Autowired
private PasswordEncoder passwordEncoder;
//	
	public UserInfo addLonginDetails(UserInfo userInfo)
	{
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		return userInfoRepository.save(userInfo);
	}
	
	public Optional<UserInfo> getUser(String userInfo)
	{
		return userInfoRepository.findByuserName(userInfo);
	}
}
