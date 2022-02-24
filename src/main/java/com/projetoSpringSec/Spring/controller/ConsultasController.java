package com.projetoSpringSec.Spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpringSec.Spring.dto.Consultas;
import com.projetoSpringSec.Spring.entity.consultaDTO;
import com.projetoSpringSec.Spring.service.ConsultasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Consultas", description = "Consultas medicas", tags = {"Consultas EndPoint"})
@RestController
@RequestMapping(value = "api-consulta/")
public class ConsultasController {

	@Autowired
	ConsultasService proxyConsult;
	
	@ApiOperation(value = "Busca todas as consultas")
	@GetMapping(value = "/consulta-all")
	public ResponseEntity<?> findAllConsultas() throws Exception{
		List<Consultas> consult = proxyConsult.findAll_Consultas();
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca consulta por id")
	@GetMapping(value = "/consulta-id/{id}")
	public ResponseEntity<?> findIDConsultas(@PathVariable int id) throws Exception{
		consultaDTO consult = proxyConsult.findconsulta_id(id);
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todas as consultas por data da consulta")
	@GetMapping(value = "/consulta-data-consulta/")
	public ResponseEntity<?> findDataone() throws Exception{
		List<Consultas> consult = proxyConsult.find_Consultas_one_date();
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todas as consultas por data da solicitação")
	@GetMapping(value = "/consulta-data-solicitacao/")
	public ResponseEntity<?> findDataoneSolicitacao() throws Exception{
		List<Consultas> consult = proxyConsult.find_Consultas_one_date_solicitacao();
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca todas as consultas entre datas between")
	@GetMapping(value = "/consulta-data-between/{data1}/{data2}")
	public ResponseEntity<?> find_Consultas_between(@PathVariable String data1,@PathVariable String data2) throws Exception{
				
		Date d1 = proxyConsult.ConvertDate(data1);
		Date d2 = proxyConsult.ConvertDate(data2);
		
		List<Consultas> consult = proxyConsult.find_Consultas_data(d1, d2);
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value ="Consulta paginada all")
	@GetMapping(value = "/consulta-all-page/")
	public ResponseEntity<?> findDataoneSolicitacao_page(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit
	) throws Exception{
		
		Pageable pageble = PageRequest.of(page, limit);
		
		List<Consultas> consult = proxyConsult.findAll_Consultas(pageble);
		return new ResponseEntity<>(consult,HttpStatus.OK);
	}
	
	@ApiOperation(value = "inserir consultas")
	@PostMapping(value = "/consulta")
	public ResponseEntity<?> InsertBeneficiario(@RequestBody Consultas dto)throws Exception{
		return new  ResponseEntity<>(proxyConsult.InsertConsulta(dto),HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "alterar consulta")
	@PutMapping(value = "/consulta")
	public  ResponseEntity<?> Updateconsulta(@RequestBody Consultas dto) throws Exception{
		return new ResponseEntity<>(proxyConsult.UpdateConsultas(dto),HttpStatus.OK);
	}
	
	@ApiOperation(value = "Alterar Status consulta")
	@PostMapping(value = "/consulta-status-consulta")
	public ResponseEntity<?> alterarStatusConsulta(@RequestBody Consultas dto)throws Exception{
		return new  ResponseEntity<>(proxyConsult.AlterarStatusConsulta(dto),HttpStatus.CREATED);
	}
}
