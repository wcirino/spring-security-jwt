package com.projetoSpringSec.Spring.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class cep {

	  private String cep;
	  private String logradouro;
	  private String complemento;
	  private String bairro;
	  private String localidade;
	  private String uf;
	  private String ibge;
	  private String gia;
	  private String ddd;
	  private String siafi;
	
}
