package com.sudagoarth.events.User.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudagoarth.events.User.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
