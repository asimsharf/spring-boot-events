package com.sudagoarth.events.Event.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Event.Entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
