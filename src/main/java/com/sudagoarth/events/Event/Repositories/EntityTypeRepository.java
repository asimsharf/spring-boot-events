package com.sudagoarth.events.Event.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Event.Entities.EntityType;
@Repository
public interface EntityTypeRepository extends JpaRepository<EntityType, Long> {

}
