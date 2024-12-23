package com.BikkadIT.BlogApplication.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.BlogApplication.payloads.ApiResponse;
import com.BikkadIT.BlogApplication.payloads.UserDto;
import com.BikkadIT.BlogApplication.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


 	@RestController
 	@RequestMapping("/api/users")

	public class UserController {
 		
 		@Autowired
		private UserService userService;
		
		//POST - Create User
		
		@PostMapping("/")
		public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
		{
			UserDto createdUSerDto = this.userService.createUser(userDto);
			return new ResponseEntity<>(createdUSerDto, HttpStatus.CREATED);
			
		}
		
		// PUT - Update User
		
		@PutMapping("/{userId}")
		public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid)
		{
			UserDto updatedUser = this.userService.updateuser(userDto, uid);
			return ResponseEntity.ok(updatedUser);
			
		}
		
		//DELETE - Delete USer
		
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
			this.userService.deleteuser(uid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
		}
		
		//GET - Get users
		
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUsers() {
			return ResponseEntity.ok(this.userService.getAllUser());
			
		}
		
		//GET - Get users
		@GetMapping("/{userId}")
		public ResponseEntity<Object> getsingleUser(@PathVariable Integer userId) {
			return ResponseEntity.ok((this.userService).getUserById(userId));
			
		}
		
		
		
		
	}





