package com.projetoSpringSec.Spring.Enum;

public enum StatusConsultas {

	ATIVO(1,"ATIVO"),
	DESATIVADO(2,"DESATIVADO");
	
	private int id;
	private String value;
	
	private StatusConsultas(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
}
