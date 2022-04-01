package com.projetoSpringSec.Spring.entity;

import java.io.Serializable;
import java.util.List;

import com.projetoSpringSec.Spring.dto.Consultas;

public class ConsultaPageDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Consultas> lista_consulta;
	private long totalElements;
	private long totalPages;
	private long size;
	private long pageNumber;
	
	public ConsultaPageDTO(List<Consultas> lista_consulta, long totalElements, long totalPages, long size,
			long pageNumber) {
		super();
		this.lista_consulta = lista_consulta;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.size = size;
		this.pageNumber = pageNumber;
	}

	public ConsultaPageDTO() {
		super();
	}

	public List<Consultas> getLista_consulta() {
		return lista_consulta;
	}

	public void setLista_consulta(List<Consultas> lista_consulta) {
		this.lista_consulta = lista_consulta;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		

}
