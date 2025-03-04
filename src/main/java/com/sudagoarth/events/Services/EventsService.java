package com.sudagoarth.events.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.DataTransferObjects.Event.EventRequest;
import com.sudagoarth.events.DataTransferObjects.Organizer.OrganizerRequest;
import com.sudagoarth.events.Interfaces.EventsInterface;
import com.sudagoarth.events.Models.Event;
import com.sudagoarth.events.Models.EventsCategory;
import com.sudagoarth.events.Models.Location;
import com.sudagoarth.events.Models.Organizer;
import com.sudagoarth.events.Repositories.EventRepository;
import com.sudagoarth.events.Repositories.EventsCategoryRepository;
import com.sudagoarth.events.Repositories.LocationRepository;
import com.sudagoarth.events.Repositories.OrganizerRepository;
import com.sudagoarth.events.exceptions.DuplicateException;

import jakarta.transaction.Transactional;

@Service
public class EventsService implements EventsInterface {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventsCategoryRepository eventsCategoryRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private OrganizerRepository organizerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsService.class);

    @Transactional // Ensures atomicity
    @Override
    public Event createEvent(EventRequest eventRequest) throws DuplicateException {
        LOGGER.info("Creating event: {}", eventRequest);
    
        // Save Category first
        EventsCategory eventsCategory = new EventsCategory(eventRequest.getCategory().getName());
        eventsCategory = eventsCategoryRepository.save(eventsCategory);
    
        // Save Event Location first
        Location eventLocation = new Location(eventRequest.getLocation());
        eventLocation = locationRepository.save(eventLocation);
    
        // Save Organizer Location first
        Location organizerLocation = new Location(eventRequest.getOrganizer().getLocation());
        organizerLocation = locationRepository.save(organizerLocation);
    
        // Save Organizer first
        Organizer organizer = new Organizer(eventRequest.getOrganizer(), organizerLocation);
        organizer = organizerRepository.save(organizer);
    
        // Create and save Event
        Event event = new Event();
        event.setEventCategory(eventsCategory);
        event.setEventLocation(eventLocation);
        event.setEventDistance(10.0);
        event.setEventImageUrl(eventRequest.getEventImageUrl());
        event.setEventName(eventRequest.getName());
        event.setEventStartDateTime(eventRequest.getStartDateTime());
        event.setEventEndDateTime(eventRequest.getEndDateTime());
        event.setOrganizer(organizer);
    
        LOGGER.info("Event created: {}", event);
        return eventRepository.save(event);
    }
    

    @Override
    public Event updateEvent(EventRequest eventRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEvent'");
    }

    @Override
    public void deleteEvent(Long eventId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvent'");
    }

    @Override
    public Event getEvent(Long eventId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvent'");
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

}
