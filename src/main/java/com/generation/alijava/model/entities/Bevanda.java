package com.generation.alijava.model.entities;

import com.generation.alijava.model.entities.abstracts.Prodotto;
import com.generation.alijava.model.entities.enums.TipologiaBevanda;
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
@DiscriminatorValue("bevanda")
public class Bevanda extends Prodotto
{
	private TipologiaBevanda tipologiaBevanda;
	private int volume;//ml
}
//Mimmo
