package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudagoarth.events.Models.EntityType;

public interface EntityTypeRepository extends JpaRepository<EntityType, Long> {

}
