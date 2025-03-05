package com.sudagoarth.events.Event.Interfaces;

import java.util.List;

import com.sudagoarth.events.Event.DataTransferObjects.EventRequest;
import com.sudagoarth.events.Event.DataTransferObjects.EventResponse;



public interface EventsInterface {
    EventResponse createEvent(EventRequest eventRequest);

    EventResponse updateEvent(EventRequest eventRequest);

    void deleteEvent(Long eventId);

    EventResponse getEvent(Long eventId);

    List<EventResponse> getAllEvents();
}
