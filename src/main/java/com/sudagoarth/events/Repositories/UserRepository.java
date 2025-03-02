package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
