package com.projetoSpringSec.Spring.controller;

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

@Api(value="medico", description = "API Para estudos", tags = {"EndPoint-Beneficario"})
@RestController
@RequestMapping(value = "/api-beneficiario")
public class BeneficiarioController {

	@Autowired
	private BeneficiarioService proxyBenef;
	
	@ApiOperation(value = "Busca beneficiario por ID")
	@GetMapping(value = "/beneficiario/{id}")
	public ResponseEntity<?> findBeneficiario(@PathVariable int id) throws Exception {
		return new ResponseEntity<>(proxyBenef.find_beneficiario_id(id),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todos beneficario")
	@GetMapping(value = "/beneficiario")
	public ResponseEntity<?> findAllBeneficiario() throws Exception{
		return new ResponseEntity<>(proxyBenef.findAll_beneficiario(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Inserir Beneficario")
	@PostMapping(value = "/beneficiario")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody Beneficiario dto)throws Exception{
		return new  ResponseEntity<>(proxyBenef.InsertBeneficiario(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Atualizar Beneficario")
	@PutMapping(value = "/beneficiario")
	public  ResponseEntity<?> UpdateBeneficiario(@RequestBody Beneficiario dto) throws Exception{
		return new ResponseEntity<>(proxyBenef.UpdateBeneficiario(dto),HttpStatus.OK);
	}
}
