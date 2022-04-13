package com.projetoSpringSec.Spring.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="consultas")
public class Consultas {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idconsulta")
	private int idconsulta;
	
	@ManyToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "codprestador", referencedColumnName="idPrest")
	private Prestador codprestador;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REMOVE) 
	@JoinColumn(name = "codbenef", referencedColumnName="idbenef")
	private Beneficiario codbenef;
	
	@Column(name = "dataconsulta")
	private Date dataconsulta;
	
	@Column(name = "datasolicitacao")
	private Date datasolicitacao;
	
	@Column(name = "tipoconsulta")
	private int tipoconsulta;
	
	@Column(name = "statusConsulta")
	private String status;
	
//	private Consultas consulta;
	
	public Consultas() {
		super();
	}

	public Consultas(int idconsulta, Prestador codprestador, Beneficiario codbenef, Date dataconsulta, Date datasolicitacao,
			int tipoconsulta, String status) {
		super();
		this.idconsulta = idconsulta;
		this.codprestador = codprestador;
		this.codbenef = codbenef;
		this.dataconsulta = dataconsulta;
		this.datasolicitacao = datasolicitacao;
		this.tipoconsulta = tipoconsulta;
		this.status = status;
	}

	public int getIdconsulta() {
		return idconsulta;
	}

	public void setIdconsulta(int idconsulta) {
		this.idconsulta = idconsulta;
	}

	public Prestador getCodprestador() {
		return codprestador;
	}

	public void setCodprestador(Prestador codprestador) {
		this.codprestador = codprestador;
	}

	public Beneficiario getCodbenef() {
		return codbenef;
	}

	public void setCodbenef(Beneficiario codbenef) {
		this.codbenef = codbenef;
	}

	public Date getDataconsulta() {
		return dataconsulta;
	}

	public void setDataconsulta(Date dataconsulta) {
		this.dataconsulta = dataconsulta;
	}

	public Date getDatasolicitacao() {
		return datasolicitacao;
	}

	public void setDatasolicitacao(Date datasolicitacao) {
		this.datasolicitacao = datasolicitacao;
	}

	public int getTipoconsulta() {
		return tipoconsulta;
	}

	public void setTipoconsulta(int tipoconsulta) {
		this.tipoconsulta = tipoconsulta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codbenef == null) ? 0 : codbenef.hashCode());
		result = prime * result + ((codprestador == null) ? 0 : codprestador.hashCode());
		result = prime * result + ((dataconsulta == null) ? 0 : dataconsulta.hashCode());
		result = prime * result + ((datasolicitacao == null) ? 0 : datasolicitacao.hashCode());
		result = prime * result + idconsulta;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + tipoconsulta;
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
		Consultas other = (Consultas) obj;
		if (codbenef == null) {
			if (other.codbenef != null)
				return false;
		} else if (!codbenef.equals(other.codbenef))
			return false;
		if (codprestador == null) {
			if (other.codprestador != null)
				return false;
		} else if (!codprestador.equals(other.codprestador))
			return false;
		if (dataconsulta == null) {
			if (other.dataconsulta != null)
				return false;
		} else if (!dataconsulta.equals(other.dataconsulta))
			return false;
		if (datasolicitacao == null) {
			if (other.datasolicitacao != null)
				return false;
		} else if (!datasolicitacao.equals(other.datasolicitacao))
			return false;
		if (idconsulta != other.idconsulta)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoconsulta != other.tipoconsulta)
			return false;
		return true;
	}

	/*
	 * public Consultas getConsulta() { return consulta; }
	 * 
	 * public void setConsulta(Consultas consulta) { this.consulta = consulta; }
	 */

	
}
