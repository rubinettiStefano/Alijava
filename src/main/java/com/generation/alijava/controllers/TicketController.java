package com.generation.alijava.controllers;

import com.generation.alijava.model.dao.TicketDao;
import com.generation.alijava.model.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
		m.addAttribute("tuttiTicket",dao.findAll());
		return ("/mostraTickets");
	}

	@PostMapping("/listaTicket")
	public String updateTicket(
			@RequestParam(required = false) String risolto,
			@RequestParam("ticketId") Long ticketId,
			Model m)
	{
		Ticket ticket = dao.findById(ticketId).orElse(null);

		if(risolto != null && risolto.equals("on"))
			ticket.setRisolto(true);
		 else
			ticket.setRisolto(false);

		dao.save(ticket);
		m.addAttribute("ticket", ticket);
		return "redirect:/listaTicket";
	}

	@GetMapping("/ticketrisolti")
	public String ticketrisolti(Model m)
	{
		List<Ticket> risolti = new ArrayList<>();

		for (Ticket ticket : dao.findAll())
			if (ticket.isRisolto())
				risolti.add(ticket);

		m.addAttribute("tickets", risolti);

		return "ticketfiltrati";
	}

	@GetMapping("/ticketnorisolto")
	public String ticketNonRisolti(Model m)
	{
		List<Ticket> nonRisolti = new ArrayList<>();
			for (Ticket ticket : dao.findAll())
				if (!ticket.isRisolto())
					nonRisolti.add(ticket);



		m.addAttribute("tickets", nonRisolti);

		return "ticketfiltrati";
	}
}
