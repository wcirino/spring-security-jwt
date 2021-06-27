package com.projetoSpringSec.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoSpringSec.Spring.dto.Beneficiario;


@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {

	Beneficiario findByIdbenef(int id);
	Beneficiario save(int id);
		
}
