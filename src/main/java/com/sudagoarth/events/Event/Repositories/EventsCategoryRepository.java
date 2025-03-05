package com.sudagoarth.events.Event.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Event.Entities.EventsCategory;

@Repository
public interface EventsCategoryRepository extends JpaRepository<EventsCategory, Long> {

    @Query("SELECT e FROM EventsCategory e WHERE e.name = ?1")
    EventsCategory findByName(String name);

}
