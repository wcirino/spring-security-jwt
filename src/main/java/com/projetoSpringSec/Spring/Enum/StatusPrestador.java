package com.projetoSpringSec.Spring.Enum;

public enum StatusPrestador {

	ATIVO(1,"ATIVO"),
	DESATIVADO(2,"DESATIVADO");
	
	private int id;
	private String value;
	
	private StatusPrestador(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
}
