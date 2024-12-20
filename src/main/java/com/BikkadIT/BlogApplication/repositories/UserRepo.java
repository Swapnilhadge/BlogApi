package com.BikkadIT.BlogApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.BlogApplication.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
