package com.sudagoarth.events.Interfaces;

import java.util.List;

import com.sudagoarth.events.DataTransferObjects.Event.EventRequest;
import com.sudagoarth.events.DataTransferObjects.Event.EventResponse;

public interface EventsInterface {
    EventResponse createEvent(EventRequest eventRequest);
    EventResponse updateEvent(EventRequest eventRequest);
    void deleteEvent(Long eventId);
    EventResponse getEvent(Long eventId);
    List<EventResponse> getAllEvents();
}
