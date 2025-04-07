package com.generation.alijava.model.entities;


import com.generation.alijava.exceptions.EntitaNotFoundException;
import com.generation.alijava.model.entities.abstracts.BaseEntity;
import com.generation.alijava.model.entities.abstracts.Prodotto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Carrello extends BaseEntity
{
	private LocalDate dataCreazione;

	@OneToMany(mappedBy = "carrello",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ItemCarrello> items;

	public void addItem(Prodotto p)
	{
		//capire se abbiamo già un item riguardate quel prodotto nel carrello
		ItemCarrello i = items.stream().filter(i1 -> i1.getProdotto().equals(p)).findFirst().orElse(null);

		if(i == null)//se è la prima volta che aggiungo il prodotto
		{
			i = new ItemCarrello();
			i.setSconto(p.getSconto());
			i.setProdotto(p);
			i.setQnt(1);
			i.setCarrello(this);
			items.add(i);
		}
		else 	//se lo ho già aumento la quantità di 1
			i.setQnt(i.getQnt()+1);
	}

	public void removeItem(Prodotto p)
	{
		//capire se abbiamo già un item riguardate quel prodotto nel carrello
		ItemCarrello i = items.stream().filter(i1 -> i1.getProdotto().equals(p)).findFirst().orElse(null);
		if(i == null)
			throw new EntitaNotFoundException("Prodotto non trovato");

		if(i.getQnt()!=1)
			i.setQnt(i.getQnt()-1);
		else
			items.remove(i);
	}

	public double getTotale()
	{
		return items.stream().mapToDouble(i -> i.getTotaleProdotto()).sum();
	}
}


