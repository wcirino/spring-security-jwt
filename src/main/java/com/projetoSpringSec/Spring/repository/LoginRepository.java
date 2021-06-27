package com.projetoSpringSec.Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoSpringSec.Spring.dto.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{

	Login findByIdlogin(int id);
	Login save(int id);
	
}
