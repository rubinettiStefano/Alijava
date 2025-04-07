package com.generation.alijava.model.entities;

import com.generation.alijava.model.entities.abstracts.Prodotto;
import com.generation.alijava.model.entities.enums.Conservazione;
import com.generation.alijava.model.entities.enums.TipologiaCibo;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
	private TipologiaCibo tipologiaCibo;
	private Conservazione conservazione;
}
