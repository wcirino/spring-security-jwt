package com.projetoSpringSec.Spring.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
@Entity
@Table(name = "beneficiario")
public class Beneficiario  extends RepresentationModel<Beneficiario> implements Serializable{
	
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
	
	@OneToMany(mappedBy = "codbenef")
	private List<Consultas> consultas = new ArrayList<Consultas>();
	
	public Beneficiario() {
		
	}
	
}
