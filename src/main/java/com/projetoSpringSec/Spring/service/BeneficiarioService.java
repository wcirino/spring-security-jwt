package com.projetoSpringSec.Spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoSpringSec.Spring.dto.Beneficiario;
import com.projetoSpringSec.Spring.dto.Login;
import com.projetoSpringSec.Spring.repository.BeneficiarioRepository;

@Service
public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository proxyBenef;
	
	@Autowired
	private LoginService proxyLogin;
	
	@Autowired
	private UtilService proxyutil;
	
	public Beneficiario find_beneficiario_id(int id) throws Exception{
		Optional<Beneficiario> obj = Optional.ofNullable(proxyBenef.findByIdbenef(id));
		return obj.orElseThrow(() -> new Exception());
	}
	
	public List<Beneficiario> findAll_beneficiario() throws Exception{
		Optional<List<Beneficiario>> obj = Optional.ofNullable(proxyBenef.findAll());
		return obj.orElseThrow(() -> new Exception());
	}
		
	public Beneficiario InsertBeneficiario(Beneficiario dto) throws Exception{
		if(!proxyBenef.existsById(dto.getIdbenef())) {
			dto.setData_cadas(new Date(System.currentTimeMillis()));
			Login lg = proxyLogin.saveService(dto.getIdlogin());
			dto.setIdlogin(lg);
			dto.setCarteirinha(proxyutil.GerandoCarteirinha());
			Beneficiario obj = proxyBenef.save(dto);
			return obj;
		}
		else {
			throw new Exception("o beneficiario possui Id");
		}
	}
	
	public Beneficiario UpdateBeneficiario(Beneficiario dto) throws Exception{
		if(proxyBenef.existsById(dto.getIdbenef())) {
			Beneficiario obj = proxyBenef.save(dto);
			return obj;
		}
		else {
			throw new Exception("o beneficiario não possui Id");
		}
	}
	
}
