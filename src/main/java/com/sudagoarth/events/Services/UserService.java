package com.sudagoarth.events.Services;


import org.springframework.stereotype.Service;

import com.sudagoarth.events.Interfaces.UserInterface;
import com.sudagoarth.events.Repositories.UserRepository;


@Service
public class UserService implements UserInterface {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
