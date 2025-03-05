package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Models.EventsCategory;

@Repository
public interface  EventsCategoryRepository extends JpaRepository<EventsCategory, Long> {

    @Query("SELECT e FROM EventsCategory e WHERE e.name = ?1")
    EventsCategory findByName(String name);
    
}
