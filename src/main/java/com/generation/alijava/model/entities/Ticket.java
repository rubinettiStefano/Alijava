package com.generation.alijava.model.entities;

import com.generation.alijava.model.entities.abstracts.BaseEntity;
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
public class Ticket extends BaseEntity
{
	private String email,titolo,contenuto;
}
