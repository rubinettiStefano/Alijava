package com.generation.alijava.model.entities;

import com.generation.alijava.model.entities.abstracts.BaseEntity;
import com.generation.alijava.model.entities.abstracts.Prodotto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ItemCarrello extends BaseEntity
{
	@ManyToOne
	@JoinColumn( name = "id_carrello")
	private Carrello carrello;
	@ManyToOne
	@JoinColumn( name = "id_prodotto")
	private Prodotto prodotto;

	private int qnt;
	private double sconto;

	public double getTotaleProdotto()
	{
		return prodotto.getPrezzoUnitario()*qnt*(1-sconto);
	}
}
