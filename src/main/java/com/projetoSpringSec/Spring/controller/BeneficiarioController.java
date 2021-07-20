package com.projetoSpringSec.Spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringSec.Spring.dto.Beneficiario;
import com.projetoSpringSec.Spring.service.BeneficiarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/api-beneficiario")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService proxyBenef;

	@GetMapping(value = "/beneficiario/{id}")
	public ResponseEntity<?> findBeneficiario(@PathVariable int id) throws Exception {
		return new ResponseEntity<>(proxyBenef.find_beneficiario_id(id),HttpStatus.OK);
	}
	
	@GetMapping(value = "/beneficiario")
	public ResponseEntity<?> findAllBeneficiario() throws Exception{
		List<Beneficiario> benef = proxyBenef.findAll_beneficiario();
		for(Beneficiario b : benef) {
			int id = b.getIdestado();
			b.add(linkTo(methodOn(BeneficiarioController.class).RetornaId(id)).withSelfRel());
		}
		return new ResponseEntity<>(benef,HttpStatus.OK);
	}
	
	@PostMapping(value = "/beneficiario")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody Beneficiario dto)throws Exception{
		return new  ResponseEntity<>(proxyBenef.InsertBeneficiario(dto),HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/beneficiario")
	public  ResponseEntity<?> UpdateBeneficiario(@RequestBody Beneficiario dto) throws Exception{
		return new ResponseEntity<>(proxyBenef.UpdateBeneficiario(dto),HttpStatus.OK);
	}
	
	@GetMapping(value = "/Aprendi-hateoas/{id}")
	public String RetornaId(@PathVariable int id) {
		return "Esse é o retorno : "+id;
	}
}
