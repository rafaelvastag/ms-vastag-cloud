package com.vastag.hroauth.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vastag.hroauth.dto.UserDTO;
import com.vastag.hroauth.feignclients.UserFeignClient;
import com.vastag.hroauth.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public Optional<UserDTO> findByEmail(String email) {
		return Optional.of(userFeignClient.findByEmail(email).getBody());
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDTO user = userFeignClient.findByEmail(email).getBody();
		if (null == user) {
			log.error("Email not found: " + email);
			throw new UsernameNotFoundException("Email" + email + "not found");
		}
		return user;
	}
}
