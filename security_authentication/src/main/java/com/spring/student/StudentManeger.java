package com.spring.student;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class StudentManeger implements AuthenticationProvider, InitializingBean {
	
	private HashMap<String, Student> studentDB = new HashMap<String,Student>();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Set.of(
				new Student("hong","È«±æµ¿",Set.of(new SimpleGrantedAuthority("ROLE_STUDENT"))),
				new Student("kang","°­¾ÆÁö",Set.of(new SimpleGrantedAuthority("ROLE_STUDENT"))),
				new Student("kim","±èÁöÈ£",Set.of(new SimpleGrantedAuthority("ROLE_STUDENT")))
				).forEach(student -> studentDB.put(student.getId(),student));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		if(studentDB.containsKey(token.getName())) {
			Student student = studentDB.get(token.getName());
			
			StudentAuthenticationToken studentAuthenticationToken = new StudentAuthenticationToken();
			studentAuthenticationToken.setPrincipal(student);
			studentAuthenticationToken.setDetails(student.getUsername());
			studentAuthenticationToken.setAuthenticated(true);
			
			return studentAuthenticationToken;
			
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication == UsernamePasswordAuthenticationToken.class;
	}

}
