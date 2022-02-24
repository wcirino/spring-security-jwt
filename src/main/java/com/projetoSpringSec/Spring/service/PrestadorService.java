package com.projetoSpringSec.Spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpringSec.Spring.dto.Beneficiario;
import com.projetoSpringSec.Spring.dto.Login;
import com.projetoSpringSec.Spring.dto.Prestador;
import com.projetoSpringSec.Spring.repository.PrestadorRepository;

@Service
public class PrestadorService {

	@Autowired
	PrestadorRepository prestProxy;
	
	@Autowired
	LoginService loginProxy;
	
	public List<Prestador> findAll_Prestador() throws Exception{
		Optional<List<Prestador>> obj = Optional.ofNullable(prestProxy.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
		
	public List<Prestador> find_prestador_id(int id) throws Exception{
		Optional<List<Prestador>> obj = Optional.ofNullable(prestProxy.findByidPrest(id));
		return obj.orElseThrow(() -> new Exception());
	}
					
	public Prestador InsertPrestador(Prestador dto) throws Exception{
		if(!prestProxy.existsById(dto.getIdPrest())) {
			
			//dto.setData_cadas(new Date(System.currentTimeMillis()));
			Login lg = loginProxy.saveService(dto.getIdlogin());
			dto.setIdlogin(lg);
			
			Prestador obj = prestProxy.save(dto);
			return obj;
		}
		else {
			throw new Exception("O Prestador possui Id");
		}
	}
	
	public Prestador UpdatePrestador(Prestador dto) throws Exception{
		if(prestProxy.existsById(dto.getIdPrest())) {
			Prestador obj = prestProxy.save(dto);
			return obj;
		}
		else {
			throw new Exception(""
					+ "O Prestador não possui Id");
		}
	}
		
}
