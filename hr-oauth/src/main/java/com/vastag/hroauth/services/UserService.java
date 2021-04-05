package com.vastag.hroauth.services;

import java.util.Optional;

import com.vastag.hroauth.dto.UserDTO;

public interface UserService {
	Optional<UserDTO> findByEmail(String email);
}
