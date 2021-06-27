package com.projetoSpringSec.Spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpringSec.Spring.dto.Login;
import com.projetoSpringSec.Spring.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository proxylogin;
	
	public Login FindLoginId(int id) throws Exception{
		Optional<Login> obj = Optional.ofNullable(proxylogin.findByIdlogin(id));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public Login saveService(Login dto) throws Exception{
	  if(!proxylogin.existsById(dto.getIdlogin())) {
		Optional<Login> obj = Optional.ofNullable(proxylogin.save(dto));
		return obj.orElseThrow(() -> new Exception());
	  }
	  else
		 throw new Exception(); 
	}
	
	public Login UpdateService(Login dto) throws Exception{
		  if(proxylogin.existsById(dto.getIdlogin())) {
			Optional<Login> obj = Optional.ofNullable(proxylogin.save(dto));
			return obj.orElseThrow(() -> new Exception());
		  }
		  else
			 throw new Exception(); 
	}	
	
}
