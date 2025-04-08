package com.generation.alijava.controllers;

import com.generation.alijava.model.dao.ProdottoDao;
import com.generation.alijava.model.entities.abstracts.Prodotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProdottoController
{

	@Autowired
	ProdottoDao dao;

	@GetMapping("/shop")
	public String shop(Model m)
	{
		m.addAttribute("listaProdotti", dao.findAll());
		return "prodotti";
	}

	@PostMapping("/shop")
	public String shopFiltrato
			(
					@RequestParam String k,
					@RequestParam Integer min,
					@RequestParam Integer max,
					@RequestParam(required = false) String offerta,
					@RequestParam(required = false) String clear,
					Model m
			)
	{
		if(clear != null)
			return "redirect:/shop";


		List<Prodotto> tutti = dao.findAll();
		List<Prodotto> filtrati = tutti.stream()
				.filter(p -> p.getNome().toLowerCase().contains(k.toLowerCase()))
				.filter(p -> min <= p.getPrezzoUnitarioScontato() && max >= p.getPrezzoUnitarioScontato())
				.collect(Collectors.toList());

		if (offerta != null)
			filtrati.removeIf(p -> p.getSconto() == 0);

		m.addAttribute("listaProdotti", filtrati);
		m.addAttribute("offerta", offerta);
		m.addAttribute("min", min);
		m.addAttribute("max", max);
		m.addAttribute("k", k);


		return "prodotti";
	}
}
