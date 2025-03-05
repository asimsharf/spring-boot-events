package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
