package com.generation.alijava.controllers;

import com.generation.alijava.model.dao.TicketDao;
import com.generation.alijava.model.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController
{

	/*
		uno mappato a POST /ticket,
		che viene chiamato quando viene submittata la form, inserisce il ticket nel db e porta alla homepage
	 */
	@Autowired
	TicketDao dao;

	@GetMapping("/ticket")
	public String inviaTicket()
	{
		return ("/inviaTicket");
	}

	@PostMapping("/ticket")
	public String salvaTicket(
			@RequestParam String email,
			@RequestParam String titolo,
			@RequestParam String contenuto
	)
	{
		Ticket nuovo = new Ticket();
		nuovo.setEmail(email);
		nuovo.setTitolo(titolo);
		nuovo.setContenuto(contenuto);
		dao.save(nuovo);
		return "/index";
	}

	@GetMapping("/listaTicket")
	public String tuttiTicket(Model m)
	{
		m.addAttribute("listaTicket",dao.findAll());
		return ("/mostraTickets");
	}
}
