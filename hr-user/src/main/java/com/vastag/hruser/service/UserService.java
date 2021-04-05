package com.vastag.hruser.service;

import java.util.Optional;

import com.vastag.hruser.entities.User;

public interface UserService {
	
	Optional<User> findByEmail(String email);

	Optional<User> findById(Long id);
}
