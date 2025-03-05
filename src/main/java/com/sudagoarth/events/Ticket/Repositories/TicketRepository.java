package com.sudagoarth.events.Ticket.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Ticket.Entities.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
