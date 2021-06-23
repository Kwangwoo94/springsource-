package com.spring.security;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SpUser {
	private String userid;
	private String email;
	private boolean enabled;
	private String password;
	
	private List<SpUserAuthority> authorities;
}
