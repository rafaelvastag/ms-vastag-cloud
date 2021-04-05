package com.vastag.hroauth.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vastag.hroauth.dto.UserDTO;
import com.vastag.hroauth.feignclients.UserFeignClient;
import com.vastag.hroauth.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public Optional<UserDTO> findByEmail(String email) {
		return Optional.of(userFeignClient.findByEmail(email).getBody());
	}
}
