package com.projetoSpringSec.Spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ConstructorBinding
@NoArgsConstructor
public class benefConsultaDTO {

	private int idbenef;
	private String nome_comp;
	private String cpfcnpj;
	//private int idestado;
	//private Integer cidade;
	private String carteirinha;
	//private int sexo;
	//private String ativo;
	private List<ConsultaBenefDTO> consultas = new ArrayList<ConsultaBenefDTO>(); 
}
