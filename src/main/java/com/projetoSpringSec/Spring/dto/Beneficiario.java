package com.projetoSpringSec.Spring.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "beneficiario")
public class Beneficiario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idbenef")
	private int idbenef;
	
	@OneToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "idlogin", referencedColumnName="idlogin")
	private Login idlogin;
	
	@NotBlank
	@Column(name = "nome_comp")
	private String nome_comp;

	@Size(min = 11, max = 20)
	@NotBlank
	@Column(name = "cpfcnpj")
	private String cpfcnpj;

	@Size(min = 11, max = 20)
	@NotBlank
	@Column(name = "RG")
	private String RG;

	@Column(name = "data_nasc")
	private Date data_nasc;

	@Column(name = "idestado")
	private int idestado;

	@Column(name = "cidade")
	private Integer cidade;

	@Size(max = 15)
	@Column(name = "telefone")
	private String telefone;

	@Size(max = 15)
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "carteirinha")
	private String carteirinha;
	
	@Column(name="data_cadas")
	private Date data_cadas;
	
	@Column(name="sexo")
	private int sexo;
	
	@Column(name="ativo")
	private String ativo;

	public Beneficiario(int idbenef, @NotBlank Login idlogin, @NotBlank String nome_comp,
			@Size(min = 11, max = 20) @NotBlank String cpfcnpj, @Size(min = 11, max = 20) @NotBlank String rG,
			Date data_nasc, int idestado, int cidade, @Size(max = 15) String telefone, @Size(max = 15) String celular,
			String carteirinha, Date data_cadas, int sexo, String ativo) {
		super();
		this.idbenef = idbenef;
		this.idlogin = idlogin;
		this.nome_comp = nome_comp;
		this.cpfcnpj = cpfcnpj;
		RG = rG;
		this.data_nasc = data_nasc;
		this.idestado = idestado;
		this.cidade = cidade;
		this.telefone = telefone;
		this.celular = celular;
		this.carteirinha = carteirinha;
		this.data_cadas = data_cadas;
		this.sexo = sexo;
		this.ativo = ativo;
	}
	
	public Beneficiario() {
		super();
	}

	
	
	public Login getIdlogin() {
		return idlogin;
	}

	public void setIdlogin(Login idlogin) {
		this.idlogin = idlogin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdbenef() {
		return idbenef;
	}

	public void setIdbenef(int idbenef) {
		this.idbenef = idbenef;
	}

	public String getNome_comp() {
		return nome_comp;
	}

	public void setNome_comp(String nome_comp) {
		this.nome_comp = nome_comp;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCarteirinha() {
		return carteirinha;
	}

	public void setCarteirinha(String carteirinha) {
		this.carteirinha = carteirinha;
	}

	public Date getData_cadas() {
		return data_cadas;
	}

	public void setData_cadas(Date data_cadas) {
		this.data_cadas = data_cadas;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((carteirinha == null) ? 0 : carteirinha.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + cidade;
		result = prime * result + ((cpfcnpj == null) ? 0 : cpfcnpj.hashCode());
		result = prime * result + ((data_cadas == null) ? 0 : data_cadas.hashCode());
		result = prime * result + ((data_nasc == null) ? 0 : data_nasc.hashCode());
		result = prime * result + idbenef;
		result = prime * result + idestado;
		result = prime * result + ((idlogin == null) ? 0 : idlogin.hashCode());
		result = prime * result + ((nome_comp == null) ? 0 : nome_comp.hashCode());
		result = prime * result + sexo;
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Beneficiario other = (Beneficiario) obj;
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (carteirinha == null) {
			if (other.carteirinha != null)
				return false;
		} else if (!carteirinha.equals(other.carteirinha))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cidade != other.cidade)
			return false;
		if (cpfcnpj == null) {
			if (other.cpfcnpj != null)
				return false;
		} else if (!cpfcnpj.equals(other.cpfcnpj))
			return false;
		if (data_cadas == null) {
			if (other.data_cadas != null)
				return false;
		} else if (!data_cadas.equals(other.data_cadas))
			return false;
		if (data_nasc == null) {
			if (other.data_nasc != null)
				return false;
		} else if (!data_nasc.equals(other.data_nasc))
			return false;
		if (idbenef != other.idbenef)
			return false;
		if (idestado != other.idestado)
			return false;
		if (idlogin == null) {
			if (other.idlogin != null)
				return false;
		} else if (!idlogin.equals(other.idlogin))
			return false;
		if (nome_comp == null) {
			if (other.nome_comp != null)
				return false;
		} else if (!nome_comp.equals(other.nome_comp))
			return false;
		if (sexo != other.sexo)
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}


	
}
