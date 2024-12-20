package com.BikkadIT.BlogApplication.services.Impl;

import java.security.PublicKey;

import java.util.List;

import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import com.BikkadIT.BlogApplication.entities.User;
import com.BikkadIT.BlogApplication.exceptions.ResourceNotFoundException;
import com.BikkadIT.BlogApplication.payloads.UserDto;
import com.BikkadIT.BlogApplication.repositories.UserRepo;
import com.BikkadIT.BlogApplication.services.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);

	}


	@Override
	public UserDto updateuser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteuser(Integer userId) {
		// TODO Auto-generated method stub
		
	}
		
		private User dtoToUser(UserDto userDto) {
			User user = new User();
			user.setId(userDto.getId());
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setAbout(userDto.getAbout());
			user.setPassword(user.getPassword());
			return user;
		}
		
		public UserDto userToDto(User user) {
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(user.getPassword());
			userDto.setAbout(user.getAbout());
			return userDto;
		
	}

}
