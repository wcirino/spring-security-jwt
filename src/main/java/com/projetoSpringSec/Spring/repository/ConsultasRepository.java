package com.projetoSpringSec.Spring.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetoSpringSec.Spring.dto.Consultas;
import com.projetoSpringSec.Spring.repository.custom.ConsultasRepositoryCustom;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, Integer>, ConsultasRepositoryCustom {

	//List<Consultas> findByIdconsulta(int id);
	
	Consultas findByIdconsulta(int id);
	
	Consultas save(int id);
	
	List<Consultas> findBydataconsultaBetween(Date dt1,Date dt2);
	
	@Query(value = "select * from consultas as c where  DATE_FORMAT(c.dataconsulta, '%Y-%m-%d') = '2022-02-24'", nativeQuery = true)
	List<Consultas> BuscaPorData();
	
	@Query(value = "select * from consultas as c where  DATE_FORMAT(c.datasolicitacao, '%Y-%m-%d') = '2022-02-21'", nativeQuery = true)
	List<Consultas> BuscaPorDataSolicitacao();
	
	@Query(value = "select c from Consultas c WHERE c.idconsulta = :id")
	List<Consultas> alterarStatusConsulta();
	
	@Transactional
	@Modifying
	@Query(value = "update Consultas c set c.status = :status where c.idconsulta = :id")
	void DesativarPrestador(@Param("status") String status, @Param("id") int id);   
	
	
//	@Query(value = "SELECT b from clienteparticularDTO b WHERE b.nome_comp like %:nomeCompleto%")
//	 public List<clienteparticularDTO> buscaPorLike(String nomeCompleto);

	
}
