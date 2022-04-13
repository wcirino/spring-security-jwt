package com.projetoSpringSec.Spring.Enum;

public enum StatusBeneficiario {

	ATIVO(1,"ATIVO"),
	DESATIVADO(2,"DESATIVADO");
	
	private int id;
	private String value;
	
	private StatusBeneficiario(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
}
