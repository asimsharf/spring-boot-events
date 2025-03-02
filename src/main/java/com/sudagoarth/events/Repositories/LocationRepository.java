package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
