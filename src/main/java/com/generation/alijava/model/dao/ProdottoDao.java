package com.generation.alijava.model.dao;

import com.generation.alijava.model.entities.Bevanda;
import com.generation.alijava.model.entities.Cibo;
import com.generation.alijava.model.entities.abstracts.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdottoDao extends JpaRepository<Prodotto, Long>
{

	@Query("SELECT c FROM Prodotto c WHERE c.class=Cibo")
	List<Cibo> leggiCibi();
	@Query("SELECT c FROM Prodotto c WHERE c.class=Bevanda")
	List<Bevanda> leggiBevande();
}
