package com.projetoSpringSec.Spring.entity;

import java.io.Serializable;

public class prestadorConsultaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cep;
	private String statusPrest;
	
	public prestadorConsultaDTO(String nome, String cep, String statusPrest) {
		super();
		this.nome = nome;
		this.cep = cep;
		this.statusPrest = statusPrest;
	}

	public prestadorConsultaDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getStatusPrest() {
		return statusPrest;
	}

	public void setStatusPrest(String statusPrest) {
		this.statusPrest = statusPrest;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((statusPrest == null) ? 0 : statusPrest.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		prestadorConsultaDTO other = (prestadorConsultaDTO) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (statusPrest == null) {
			if (other.statusPrest != null)
				return false;
		} else if (!statusPrest.equals(other.statusPrest))
			return false;
		return true;
	}
	
}
