package com.generation.alijava.model.entities.enums;

import lombok.Getter;

@Getter
public enum Conservazione
{
	SURGELATO("Surgelato"),
	FRIGO("Frigo"),
	FRESCO("Fresco"),
	LUNGA_CONSERVAZIONE("A Lunga Conservazione"),
	;


	Conservazione(String nomeStampabile)
	{
		this.nomeStampabile = nomeStampabile;
	}

	private final String nomeStampabile;

}
