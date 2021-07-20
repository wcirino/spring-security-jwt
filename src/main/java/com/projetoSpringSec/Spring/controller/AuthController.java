package com.projetoSpringSec.Spring.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringSec.Spring.dto.AccountCredentials;
import com.projetoSpringSec.Spring.repository.UserRepository;
import com.projetoSpringSec.Spring.security.jwt.JwtTokenProvider;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="medico", description = "API de Autenticação", tags = {"EndPoint-Autenticação"})
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenProvider tokenProvider;
	
	@Autowired
	UserRepository repository;
	
	@ApiOperation(value = "Authenticates a user and returns a token")
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/signin")
	public ResponseEntity signin(@RequestBody AccountCredentials data) {
		try {
			var username = data.getUsername();
			var pasword = data.getPassword();
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pasword));
			
			var user = repository.findBylogin(username);
			
			var token = "";
			
			if (user != null) {
				token = tokenProvider.createToken(username, user.getRole());
			} else {
				throw new UsernameNotFoundException("Username " + username + " not found!");
			}
			
			Map<Object, Object> model = new HashMap<>();
			model.put("username", username);
			model.put("token", token);
			return ok(model);
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid username/password supplied! : " +e.getMessage());
		}
	}
	
	/*
	 * @GetMapping(value = "/refresh_token") public ResponseEntity<Void>
	 * refreshToken(HttpServletResponse response) { var user =
	 * repository.findBylogin(username); String token =
	 * jwtUtil.generateToken(user.getUsername());
	 * response.addHeader("Authorization", "Bearer " + token);
	 * response.addHeader("access-control-expose-headers", "Authorization"); return
	 * ResponseEntity.noContent().build(); }
	 */
	
}