package com.projetoSpringSec.Spring.dto;

import java.util.Date;



public class Consulta {


	private int idconsulta;
	private Prestador codprestador;
	private int codbenef;
	private Date dataconsulta;
	private Date datasolicitacao;
	private int tipoconsulta;
	private String status;
	private Consulta consulta;	
	
	public Consulta() {
		super();
	}

	public Consulta(int idconsulta, Prestador codprestador, int codbenef, Date dataconsulta, Date datasolicitacao,
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
	
	
	
	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
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
	public int getCodbenef() {
		return codbenef;
	}
	public void setCodbenef(int codbenef) {
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
	
//	private Consultas consulta;
	
	
	
}
