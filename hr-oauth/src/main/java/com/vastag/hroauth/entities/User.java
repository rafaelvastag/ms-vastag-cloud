package com.vastag.hroauth.entities;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Long id;
	
	private String name;

	private String email;
	
	private String password;

	private Set<Role> roles = new HashSet<Role>();
}
