package com.projetoSpringSec.Spring.entity;

import java.io.Serializable;
import java.util.Date;

public class prestadorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idPrest;
	private String nome;
	private String cpf;
	private loginDTO idlogin;
	private int sexo;
	private Date dataNascimento;
	private String endereco;
	private int cidade;
	private int estados;
	private String cep;
	private String statusPrest;
	private String dataCadastro;
	
	public prestadorDTO() {
		super();
	}

	public prestadorDTO(int idPrest, String nome, String cpf, loginDTO idlogin, int sexo, Date dataNascimento,
			String endereco, int cidade, int estados, String cep, String statusPrest, String dataCadastro) {
		super();
		this.idPrest = idPrest;
		this.nome = nome;
		this.cpf = cpf;
		this.idlogin = idlogin;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estados = estados;
		this.cep = cep;
		this.statusPrest = statusPrest;
		this.dataCadastro = dataCadastro;
	}

	public int getIdPrest() {
		return idPrest;
	}

	public void setIdPrest(int idPrest) {
		this.idPrest = idPrest;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public loginDTO getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(loginDTO idlogin) {
		this.idlogin = idlogin;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}

	public int getEstados() {
		return estados;
	}

	public void setEstados(int estados) {
		this.estados = estados;
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

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + cidade;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + estados;
		result = prime * result + idPrest;
		result = prime * result + ((idlogin == null) ? 0 : idlogin.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + sexo;
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
		prestadorDTO other = (prestadorDTO) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade != other.cidade)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estados != other.estados)
			return false;
		if (idPrest != other.idPrest)
			return false;
		if (idlogin == null) {
			if (other.idlogin != null)
				return false;
		} else if (!idlogin.equals(other.idlogin))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo != other.sexo)
			return false;
		if (statusPrest == null) {
			if (other.statusPrest != null)
				return false;
		} else if (!statusPrest.equals(other.statusPrest))
			return false;
		return true;
	}
	
}
