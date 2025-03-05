package com.sudagoarth.events.Organizer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Organizer.Entities.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

    @Query("SELECT o FROM Organizer o WHERE o.email = ?1")
    Organizer findByEmail(String email);
}
