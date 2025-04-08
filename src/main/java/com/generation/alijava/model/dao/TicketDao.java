package com.generation.alijava.model.dao;

import com.generation.alijava.model.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDao extends JpaRepository<Ticket, Long>
{
}
