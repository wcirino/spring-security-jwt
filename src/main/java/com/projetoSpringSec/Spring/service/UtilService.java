package com.projetoSpringSec.Spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpringSec.Spring.dto.Cidade;
import com.projetoSpringSec.Spring.dto.Estado;
import com.projetoSpringSec.Spring.repository.CidadeRepository;
import com.projetoSpringSec.Spring.repository.EstadoRepository;

@Service
public class UtilService {

	@Autowired
	private CidadeRepository proxyCidade;
	
	@Autowired
	private EstadoRepository proxyEstado;
	
	public List<Cidade> findAllCidade(int id){
		return proxyCidade.findByIdestado(id);
	}
	
	public List<Estado> findAllestado(){
		return proxyEstado.findAll();
	}
	
}
