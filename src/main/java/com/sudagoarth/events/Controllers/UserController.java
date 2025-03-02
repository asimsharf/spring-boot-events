package com.sudagoarth.events.Controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudagoarth.events.Interfaces.UserInterface;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserInterface userService;

    public UserController(UserInterface userService) {
        this.userService = userService;
    }


}
