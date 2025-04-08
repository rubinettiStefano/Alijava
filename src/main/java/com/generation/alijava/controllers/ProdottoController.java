package com.generation.alijava.controllers;

import com.generation.alijava.model.dao.ProdottoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
