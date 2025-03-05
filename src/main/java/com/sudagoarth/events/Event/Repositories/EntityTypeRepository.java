package com.sudagoarth.events.Event.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudagoarth.events.Event.Entities.EntityType;

public interface EntityTypeRepository extends JpaRepository<EntityType, Long> {

}
