package com.generation.alijava.model.entities;

import com.generation.alijava.model.entities.abstracts.Prodotto;
import com.generation.alijava.model.entities.enums.Conservazione;
import com.generation.alijava.model.entities.enums.TipologiaCibo;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("cibo")
public class Cibo extends Prodotto
{
	private double peso;//kg
	@Enumerated(EnumType.STRING)
	private TipologiaCibo tipologiaCibo;
	@Enumerated(EnumType.STRING)
	private Conservazione conservazione;

	public String getStampaEnum()
	{
		return conservazione.getNomeStampabile();
	}
}
