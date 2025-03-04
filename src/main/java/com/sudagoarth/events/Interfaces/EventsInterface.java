package com.sudagoarth.events.Interfaces;

import java.util.List;

import com.sudagoarth.events.DataTransferObjects.Event.EventRequest;
import com.sudagoarth.events.Models.Event;

public interface EventsInterface {
    Event createEvent(EventRequest eventRequest);
    Event updateEvent(EventRequest eventRequest);
    void deleteEvent(Long eventId);
    Event getEvent(Long eventId);
    List<Event> getAllEvents();
}
