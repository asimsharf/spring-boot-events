package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Models.Event;
import com.sudagoarth.events.Models.Ticket;
import com.sudagoarth.events.Models.User;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
