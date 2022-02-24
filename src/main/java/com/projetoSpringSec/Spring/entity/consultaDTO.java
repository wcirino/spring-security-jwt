package com.projetoSpringSec.Spring.entity;

import java.util.Date;

public class consultaDTO {


	private int idconsulta;
	
	private prestadorConsultaDTO codprestador;

	private beneficiarioDTO beneficiario;
	private Date dataconsulta;
	private Date datasolicitacao;
	private int tipoconsulta;
	private String status;
	
	public consultaDTO() {
		super();
	}

	public consultaDTO(int idconsulta, prestadorConsultaDTO codprestador, beneficiarioDTO codbenef, Date dataconsulta,
			Date datasolicitacao, int tipoconsulta, String status) {
		super();
		this.idconsulta = idconsulta;
		this.codprestador = codprestador;
		this.beneficiario = codbenef;
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

	public prestadorConsultaDTO getPrestador() {
		return codprestador;
	}

	public void setPrestador(prestadorConsultaDTO prestador) {
		this.codprestador = codprestador;
	}

	public beneficiarioDTO getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(beneficiarioDTO beneficiario) {
		this.beneficiario = beneficiario;
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
	
	
}
