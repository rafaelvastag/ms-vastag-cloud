package com.vastag.hruser.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vastag.hruser.entities.User;
import com.vastag.hruser.repositories.UserRepository;
import com.vastag.hruser.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	public Optional<User> findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Optional<User> findById(Long id) {
		return repository.findById(id);
	}
}
