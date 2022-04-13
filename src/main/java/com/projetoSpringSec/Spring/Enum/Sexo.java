package com.projetoSpringSec.Spring.Enum;

import lombok.Getter;

@Getter
public enum Sexo {

	MASCULINO(1,"Masculino"),
	FEMININO(2,"Feminino");
	
	private int id;
	private String value;

	private Sexo(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
	
}
