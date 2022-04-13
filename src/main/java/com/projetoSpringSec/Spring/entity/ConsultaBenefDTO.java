package com.projetoSpringSec.Spring.entity;

import java.util.Date;

import org.springframework.boot.context.properties.ConstructorBinding;

import com.projetoSpringSec.Spring.dto.Prestador;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ConstructorBinding
@NoArgsConstructor
public class ConsultaBenefDTO {

	private int idconsulta;
	private Date dataconsulta;
	private Date datasolicitacao;
	private int tipoconsulta;
	private String status;
	
}
