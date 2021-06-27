package com.projetoSpringSec.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoSpringSec.Spring.dto.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
}
