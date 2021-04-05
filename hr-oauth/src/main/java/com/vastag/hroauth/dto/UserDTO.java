package com.vastag.hroauth.dto;

import java.util.HashSet;
import java.util.Set;

import com.vastag.hroauth.entities.Role;

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
	private Set<RoleDTO> roles = new HashSet<RoleDTO>();
}
