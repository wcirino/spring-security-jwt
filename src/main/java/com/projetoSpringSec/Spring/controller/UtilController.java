package com.projetoSpringSec.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringSec.Spring.service.UtilService;

@RestController
@RequestMapping(value = "/api-util")
public class UtilController {

	@Autowired
	private UtilService proxyutil;
	
	@GetMapping(value = "/estado")
	public ResponseEntity<?> findAllEstados(){
		return new ResponseEntity<>(proxyutil.findAllestado(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/cidade/{id}")
	public ResponseEntity<?> findAllCidade(@PathVariable int id){
		return new ResponseEntity<>(proxyutil.findAllCidade(id),HttpStatus.OK);
	}
}
 