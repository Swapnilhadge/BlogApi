package com.BikkadIT.BlogApplication.services;

import java.util.List;

import com.BikkadIT.BlogApplication.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateuser(UserDto user,Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteuser(Integer userId);
	

}
