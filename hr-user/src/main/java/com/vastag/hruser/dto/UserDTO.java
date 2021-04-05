package com.vastag.hruser.dto;

import java.util.HashSet;
import java.util.Set;

import com.vastag.hruser.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<Role>();
}
