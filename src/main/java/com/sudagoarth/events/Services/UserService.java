package com.sudagoarth.events.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.Interfaces.UserInterface;
import com.sudagoarth.events.Repositories.UserRepository;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsService.class);

}
