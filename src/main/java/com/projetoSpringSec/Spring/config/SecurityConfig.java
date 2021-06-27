package com.projetoSpringSec.Spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projetoSpringSec.Spring.security.jwt.JwtConfigurer;
import com.projetoSpringSec.Spring.security.jwt.JwtTokenProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic().disable()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.authorizeRequests()
				.antMatchers("/auth/signin", "/api-docs/**", "/api-util/**","/swagger-ui.html**").permitAll()
				.antMatchers(HttpMethod.POST, "/api-beneficiario/beneficiario").permitAll()
				.antMatchers(HttpMethod.GET,  "/api-beneficiario/beneficiario").permitAll()
				.antMatchers(HttpMethod.GET,  "/api-beneficiario/beneficiario/").permitAll()
				.anyRequest()
				.authenticated()
			.and()
			.apply(new JwtConfigurer(tokenProvider));
	}

}
