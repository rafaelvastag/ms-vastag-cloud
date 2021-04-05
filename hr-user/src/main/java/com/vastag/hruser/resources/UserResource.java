package com.vastag.hruser.resources;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vastag.hruser.dto.UserDTO;
import com.vastag.hruser.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@RefreshScope
public class UserResource {

	private final UserService service;
	private final ModelMapper modelMapper;

	@GetMapping(value = "/search")
	public ResponseEntity<UserDTO> findByEmail(@RequestParam(name = "email") String email) {

		UserDTO user = service.findByEmail(email).map(entity -> modelMapper.map(entity, UserDTO.class))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findByUserId(@PathVariable(name = "id") Long id) {

		UserDTO user = service.findById(id).map(entity -> modelMapper.map(entity, UserDTO.class))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		return ResponseEntity.ok(user);
	}

}
