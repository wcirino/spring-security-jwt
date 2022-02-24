package com.projetoSpringSec.Spring.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import com.projetoSpringSec.Spring.config.ModelMapperConfig;
import com.projetoSpringSec.Spring.dto.Consultas;
import com.projetoSpringSec.Spring.entity.consultaDTO;
import com.projetoSpringSec.Spring.repository.ConsultasRepository;

@Service
public class ConsultasService {

	@Autowired
	private ConsultasRepository consulProxy;
	
	@Autowired
	private ModelMapperConfig modelMapper;
	
	private ModelMapper m = new ModelMapper();
	
	public List<Consultas> findAll_Consultas() throws Exception{
		Optional<List<Consultas>> obj = Optional.ofNullable(consulProxy.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
		
//	public List<Consultas> find_consulta_id(int id) throws Exception{
//		Optional<List<Consultas>> obj = Optional.ofNullable(consulProxy.findByIdconsulta(id));
//		return obj.orElseThrow(() -> new Exception());
//	}
	
	public consultaDTO findconsulta_id(int id) throws Exception{
		Consultas c = consulProxy.findByIdconsulta(id);
		Optional<consultaDTO> obj = Optional.ofNullable(PrestadormodelMapperOne(consulProxy.findByIdconsulta(id)));
		return obj.orElseThrow(() -> new Exception());
	}
	
	
	public List<Consultas> find_Consultas_data(Date dt1, Date dt2) throws Exception{
		Optional<List<Consultas>> obj = Optional.ofNullable(consulProxy.findBydataconsultaBetween(dt1, dt2));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<Consultas> find_Consultas_one_date_solicitacao() throws Exception{
		Optional<List<Consultas>> obj = Optional.ofNullable(consulProxy.BuscaPorDataSolicitacao());
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<Consultas> find_Consultas_one_date() throws Exception{
		Optional<List<Consultas>> obj = Optional.ofNullable(consulProxy.BuscaPorData());
		return obj.orElseThrow(() -> new Exception());
	}
		
			
	public Consultas InsertConsulta(Consultas dto) throws Exception{
		if(!consulProxy.existsById(dto.getIdconsulta())) {
			Consultas obj = consulProxy.save(dto);
			return obj;
		}
		else {
			throw new Exception("A Consulta possui Id");
		}
	}
	
	public Consultas UpdateConsultas(Consultas dto) throws Exception{
		if(consulProxy.existsById(dto.getIdconsulta())) {
			Consultas obj = consulProxy.save(dto);
			return obj;
		}
		else {
			throw new Exception(""
					+ "A consulta não possui Id");
		}
	}
	
	public Date ConvertDate(String dt) throws Exception{
		
		dt = dt.replaceAll("-", "/");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); 
		Date d = format.parse(dt);
		
		return d;
	}

	public List<Consultas> findAll_Consultas(Pageable pageble) throws Exception {
		Optional<List<Consultas>> obj = Optional.ofNullable(consulProxy.findAll(pageble).getContent());
		return obj.orElseThrow(() -> new Exception());
	}
	
	public String AlterarStatusConsulta(Consultas dto) throws Exception {
		consulProxy.DesativarPrestador(dto.getStatus(),dto.getIdconsulta());
		return "ok";
	}
	
	private consultaDTO PrestadormodelMapperOne(Consultas dto) {
		consultaDTO consult = m.map(dto, consultaDTO.class);
		return consult;
	}
	
	private List<consultaDTO> PrestadorModelMapperList(List<Consultas> dto){	
		  return dto.stream().map(obj -> PrestadormodelMapperOne(obj)).collect(Collectors.toList());
	}

	
}
