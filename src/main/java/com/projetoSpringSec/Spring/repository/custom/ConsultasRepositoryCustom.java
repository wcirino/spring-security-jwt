package com.projetoSpringSec.Spring.repository.custom;

import java.util.List;

import com.projetoSpringSec.Spring.dto.Consulta;
import com.projetoSpringSec.Spring.dto.Consultas;

public interface ConsultasRepositoryCustom {

	List<Consultas> getAll();
	Consultas getConsultasByidconsulta(int id);
	List<Consultas> BuscaQueryNative();
	List<Consultas> BuscaQueryNative2();
	//List<Consultas> getidconsulta_();
}
