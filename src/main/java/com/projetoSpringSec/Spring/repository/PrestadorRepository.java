package com.projetoSpringSec.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoSpringSec.Spring.dto.Prestador;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Integer>{

	List<Prestador> findByidPrest(int id);
	
	Prestador save(int id);
	
}
