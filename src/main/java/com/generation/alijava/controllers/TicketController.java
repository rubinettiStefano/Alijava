package com.generation.alijava.controllers;


import com.generation.alijava.model.dao.TicketDao;
import com.generation.alijava.model.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TicketController {

    @Autowired
    TicketDao tdao;

    @GetMapping("/Contatta")
    public String contattaci(Model m) {
        return "inviaTicket";
    }

    @PostMapping("/Contatta")
    public String creaTicket
            (
                Model m,
                @RequestParam String email,
                @RequestParam String titolo,
                @RequestParam String contenuto
            ) {

        Ticket t = new Ticket();
        t.setEmail(email);
        t.setTitolo(titolo);
        t.setContenuto(contenuto);
        tdao.save(t);

        return "index";
    }

    @GetMapping("/listaTicket")
    public String ticketList(Model m) {

        List<Ticket> t = tdao.findAll();
        m.addAttribute("t",t);
        return "mostraTicket";
    }
}
