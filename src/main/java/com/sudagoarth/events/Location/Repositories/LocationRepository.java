package com.sudagoarth.events.Location.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Location.Entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l WHERE l.latitude = ?1 AND l.longitude = ?2")
    Location findByLatAndLng(double latitude, double longitude);
}
