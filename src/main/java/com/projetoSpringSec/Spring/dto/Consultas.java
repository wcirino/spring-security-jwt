package com.projetoSpringSec.Spring.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consultas {

	private int idconsulta;
	private Prestador codprestador;
	private Beneficiario codbenef;
	private Date dataconsulta;
	private Date datasolicitacao;
	private int tipoconsulta;
	private String status;
		
}
