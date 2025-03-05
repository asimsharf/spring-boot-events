package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
