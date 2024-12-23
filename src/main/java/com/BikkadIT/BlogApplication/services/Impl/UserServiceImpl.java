package com.BikkadIT.BlogApplication.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BikkadIT.BlogApplication.entities.User;
import com.BikkadIT.BlogApplication.exceptions.ResourceNotFoundException;
import com.BikkadIT.BlogApplication.payloads.UserDto;
import com.BikkadIT.BlogApplication.repositories.UserRepo;
import com.BikkadIT.BlogApplication.services.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	
	//--> Create User:-
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);

	}

	//--> Update User:-
	
	@Override
	public UserDto updateUser(UserDto userDto, Integer UserId) {
		
		User user = this.userRepo.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", UserId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updateUser);
		return userDto1;
	}
	
	
	//--> Get User:-
	
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
		
		}
	
	
	
	//--> Create All User:-
	
	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
				List<UserDto> usersDtos = users.stream().
				map(user -> this.userToDto(user)).collect(Collectors.toList());
		return usersDtos;
	}
	
	

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).
		orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
		

	}
		
		private User dtoToUser(UserDto userDto) {
			User user = new User();
			user.setId(userDto.getId());
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
			user.setAbout(userDto.getAbout());
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
