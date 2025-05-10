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
	@Autowired
	private TicketDao ticketDao;

	@GetMapping("/inviaticket")
	public String mostraForm()
	{
		return "inviaTicket";
	}

	@GetMapping("/mostratickets")
	public String mostraTickets(Model model) {
		model.addAttribute("tickets", ticketDao.findAll());
		return "mostraTickets";
	}

	@PostMapping("/inviaticket")
	public String inviaTicket
			(
					@RequestParam String email,
					@RequestParam String titolo,
					@RequestParam String contenuto

			)
	{
		Ticket nuovoTicket = new Ticket();
		nuovoTicket.setTitolo(titolo);
		nuovoTicket.setContenuto(contenuto);
		nuovoTicket.setEmail(email);
		ticketDao.save(nuovoTicket);
		return "redirect:/";
	}
}
