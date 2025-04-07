package com.generation.alijava.model.entities.abstracts;

import com.generation.alijava.model.entities.ItemCarrello;
import com.generation.alijava.model.entities.Sconto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn(name = "concrete_type")
public abstract class Prodotto extends BaseEntity
{
	private String nome;
	private String descrizione;
	private double prezzoUnitario;
	private int qnt;

	//											cascade all			 APPLICA 2 POLITICHE
	//													1 - NIENTE ORFANI
	//											2 - POSSO CAMBIARE I FIGLI SUL DB DAL PADRE IN JAVA
	//											es: se aggiungo un figlio alla lista e poi salvo il padre(prodotto), lui salva sul db anche il figlio
	@OneToMany(mappedBy = "prodotto",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Sconto> sconti;

	@OneToMany(mappedBy = "prodotto",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ItemCarrello> items;

	public double getSconto()
	{
		return sconti.stream().filter
				(s -> LocalDate.now().plusDays(1).isAfter(s.getInizio())	&&
						     LocalDate.now().minusDays(1).isBefore(s.getFine())
				).map(s -> s.getValore()).findFirst().orElse(0.0);
		//1 - prendo lista sconti e faccio lo stream
		//2 - tengo solo gli sconti (0 o 1) il cui inizio è maggiore= oggi e fine minore<=oggi
		//3 - con il map trasformo lo sconto nel suo valore numerico
		//4 -  se esiste lo prendo, altrimenti dico che lo sconto è 0
	}

	public double getPrezzoUnitarioScontato()
	{
		return prezzoUnitario * (1-getSconto());
	}
}


