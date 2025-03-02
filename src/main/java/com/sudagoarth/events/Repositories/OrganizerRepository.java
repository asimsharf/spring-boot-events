package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Models.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
