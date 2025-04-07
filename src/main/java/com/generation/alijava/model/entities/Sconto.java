package com.generation.alijava.model.entities;

import com.generation.alijava.model.entities.abstracts.BaseEntity;
import com.generation.alijava.model.entities.abstracts.Prodotto;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Sconto extends BaseEntity
{

	private LocalDate inizio,fine;
	private double valore;

	@ManyToOne
	@JoinColumn(name = "id_prodotto")
	private Prodotto prodotto;

}
