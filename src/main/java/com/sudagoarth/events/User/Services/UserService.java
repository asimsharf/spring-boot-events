package com.sudagoarth.events.User.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.Event.Services.EventsService;
import com.sudagoarth.events.User.Interfaces.UserInterface;
import com.sudagoarth.events.User.Repositories.UserRepository;

@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsService.class);

}
