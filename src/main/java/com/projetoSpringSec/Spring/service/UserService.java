package com.projetoSpringSec.Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetoSpringSec.Spring.dto.User;
import com.projetoSpringSec.Spring.repository.UserRepository;

@Service
public class UserService  implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	public UserService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findBylogin(username);
		if(user != null)
			return user;
		else
			throw new UsernameNotFoundException("Username :"+ username + " not found");
	}

}
