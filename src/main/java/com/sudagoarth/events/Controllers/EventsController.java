package com.sudagoarth.events.Controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudagoarth.events.DataTransferObjects.Event.EventRequest;
import com.sudagoarth.events.DataTransferObjects.Event.EventResponse;
import com.sudagoarth.events.Interfaces.EventsInterface;
import com.sudagoarth.events.exceptions.ApiResponse;

@RestController
@RequestMapping("/api/v1/events")
public class EventsController {

    @Autowired
    private EventsInterface eventsInterface;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsCategoryController.class.getName());

    @GetMapping
    public ResponseEntity<ApiResponse> getAllEvents() {
        LOGGER.info("Fetching all events");
        List<EventResponse> events = eventsInterface.getAllEvents();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(null, HttpStatus.OK.value(), events));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createEvent(@RequestBody EventRequest eventRequest) {
        LOGGER.info("Creating event");
        EventResponse event = eventsInterface.createEvent(eventRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(null, HttpStatus.CREATED.value(), event));
    }

}
