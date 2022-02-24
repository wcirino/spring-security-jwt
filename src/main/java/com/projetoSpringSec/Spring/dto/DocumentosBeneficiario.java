package com.projetoSpringSec.Spring.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivos")
public class DocumentosBeneficiario {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name = "idarquivo")
	private int idarquivo;
	
	@Column(name = "codbenef")
	private int codbenef;
	
	@Column(name = "codprest")
	private int codprest;
	
	@Column(name = "nomearquivo")
	private String nomearquivo;
	
	@Column(name = "dataarquivo")
	private Date dataarquivo;
	
	@Column(name = "tipoarquivo")
	private int tipoarquivo;
	
	public DocumentosBeneficiario() {
		super();
	}

	public DocumentosBeneficiario(int idarquivo, int codbenef, int codprest, String nomearquivo, Date dataarquivo,
			int tipoarquivo) {
		super();
		this.idarquivo = idarquivo;
		this.codbenef = codbenef;
		this.codprest = codprest;
		this.nomearquivo = nomearquivo;
		this.dataarquivo = dataarquivo;
		this.tipoarquivo = tipoarquivo;
	}

	public int getIdarquivo() {
		return idarquivo;
	}

	public void setIdarquivo(int idarquivo) {
		this.idarquivo = idarquivo;
	}

	public int getCodbenef() {
		return codbenef;
	}

	public void setCodbenef(int codbenef) {
		this.codbenef = codbenef;
	}

	public int getCodprest() {
		return codprest;
	}

	public void setCodprest(int codprest) {
		this.codprest = codprest;
	}

	public String getNomearquivo() {
		return nomearquivo;
	}

	public void setNomearquivo(String nomearquivo) {
		this.nomearquivo = nomearquivo;
	}

	public Date getDataarquivo() {
		return dataarquivo;
	}

	public void setDataarquivo(Date dataarquivo) {
		this.dataarquivo = dataarquivo;
	}

	public int getTipoarquivo() {
		return tipoarquivo;
	}

	public void setTipoarquivo(int tipoarquivo) {
		this.tipoarquivo = tipoarquivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codbenef;
		result = prime * result + codprest;
		result = prime * result + ((dataarquivo == null) ? 0 : dataarquivo.hashCode());
		result = prime * result + idarquivo;
		result = prime * result + ((nomearquivo == null) ? 0 : nomearquivo.hashCode());
		result = prime * result + tipoarquivo;
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
		DocumentosBeneficiario other = (DocumentosBeneficiario) obj;
		if (codbenef != other.codbenef)
			return false;
		if (codprest != other.codprest)
			return false;
		if (dataarquivo == null) {
			if (other.dataarquivo != null)
				return false;
		} else if (!dataarquivo.equals(other.dataarquivo))
			return false;
		if (idarquivo != other.idarquivo)
			return false;
		if (nomearquivo == null) {
			if (other.nomearquivo != null)
				return false;
		} else if (!nomearquivo.equals(other.nomearquivo))
			return false;
		if (tipoarquivo != other.tipoarquivo)
			return false;
		return true;
	}
		
}
