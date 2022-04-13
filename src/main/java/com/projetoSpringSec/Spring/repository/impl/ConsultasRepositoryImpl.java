package com.projetoSpringSec.Spring.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.projetoSpringSec.Spring.dto.Consulta;
import com.projetoSpringSec.Spring.dto.Consultas;
import com.projetoSpringSec.Spring.repository.custom.ConsultasRepositoryCustom;

@Repository
public class ConsultasRepositoryImpl implements ConsultasRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Consultas> getAll() {
		List<Consultas> consultas = entityManager.createQuery("SELECT c FROM Consultas c", Consultas.class)
									.getResultList();
		return consultas;
	}

	@Override
	public Consultas getConsultasByidconsulta(int id) {
		Consultas consultas = entityManager.createQuery("SELECT c FROM Consultas c WHERE c.idconsulta = :id ", Consultas.class)
										   .setParameter("id", id)
										   .getSingleResult();
		return consultas;
	}

	@Override
	public List<Consultas> BuscaQueryNative() {
		List<Consultas> consultas = entityManager.createQuery("SELECT c FROM Consultas c", Consultas.class)
				.getResultList();
		return consultas;
	}

	@Override
	public List<Consultas> BuscaQueryNative2() {
		List<Consultas> consultas ;
		Query query = entityManager.createNativeQuery("SELECT * FROM consultas c", Consultas.class);
		consultas = query.getResultList();
		return consultas;
	}

	
	
}
