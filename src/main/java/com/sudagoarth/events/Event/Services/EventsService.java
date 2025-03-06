package com.sudagoarth.events.Event.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.Event.DataTransferObjects.EventRequest;
import com.sudagoarth.events.Event.DataTransferObjects.EventResponse;
import com.sudagoarth.events.Event.Entities.Event;
import com.sudagoarth.events.Event.Entities.EventsCategory;

import com.sudagoarth.events.Event.Interfaces.EventsInterface;
import com.sudagoarth.events.Event.Repositories.EventRepository;
import com.sudagoarth.events.Event.Repositories.EventsCategoryRepository;
import com.sudagoarth.events.Location.Entities.Location;
import com.sudagoarth.events.Location.Repositories.LocationRepository;
import com.sudagoarth.events.Organizer.Entities.Organizer;
import com.sudagoarth.events.Organizer.Repositories.OrganizerRepository;
import com.sudagoarth.events.exceptions.DuplicateException;
import com.sudagoarth.events.exceptions.NotFoundException;

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
    public EventResponse createEvent(EventRequest eventRequest) throws DuplicateException {
        LOGGER.info("Creating event: {}", eventRequest);

        // Check if the category already exists
        EventsCategory eventsCategory = eventsCategoryRepository.findByName(eventRequest.getCategory().getName());

        // If the category doesn't exist, create and save it
        if (eventsCategory == null) {
            eventsCategory = new EventsCategory(eventRequest.getCategory().getName());
            eventsCategory = eventsCategoryRepository.save(eventsCategory);
        }

        // Check if the location already exists, lat, lng
        Location eventLocation = locationRepository.findByLatAndLng(eventRequest.getLocation().getLatitude(),
                eventRequest.getLocation().getLongitude());

        // If the location already exists, throw an exception
        if (eventLocation == null) {
            eventLocation = new Location(eventRequest.getLocation());
            eventLocation = locationRepository.save(eventLocation);
        }

        // Save Organizer Location
        Location organizerLocation = new Location(eventRequest.getOrganizer().getLocation());
        organizerLocation = locationRepository.save(organizerLocation);

        // Save Organizer
        Organizer organizer = organizerRepository.findByEmail(eventRequest.getOrganizer().getEmail());
        if (organizer == null) {
            organizer = new Organizer(eventRequest.getOrganizer(), organizerLocation);
            organizer = organizerRepository.save(organizer);
        }

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

        Event savedEvent = eventRepository.save(event);
        return new EventResponse(savedEvent);

    }

    @Override
    public EventResponse updateEvent(EventRequest eventRequest) throws NotFoundException {

        LOGGER.info("Updating event: {}", eventRequest);
        Event event = eventRepository.findById(eventRequest.getId())
                .orElseThrow(() -> new NotFoundException("Event not found"));

        // Check if the category already exists
        EventsCategory eventsCategory = eventsCategoryRepository.findByName(eventRequest.getCategory().getName());

        // If the category doesn't exist, create and save it
        if (eventsCategory == null) {
            eventsCategory = new EventsCategory(eventRequest.getCategory().getName());
            eventsCategory = eventsCategoryRepository.save(eventsCategory);
        }

        // Save Event Location
        Location eventLocation = new Location(eventRequest.getLocation());
        eventLocation = locationRepository.save(eventLocation);

        // Save Organizer Location
        Location organizerLocation = new Location(eventRequest.getOrganizer().getLocation());
        organizerLocation = locationRepository.save(organizerLocation);

        // Save Organizer
        Organizer organizer = new Organizer(eventRequest.getOrganizer(), organizerLocation);
        organizer = organizerRepository.save(organizer);

        // Update Event
        event.setEventCategory(eventsCategory);
        event.setEventLocation(eventLocation);
        event.setEventDistance(10.0);
        event.setEventImageUrl(eventRequest.getEventImageUrl());
        event.setEventName(eventRequest.getName());
        event.setEventStartDateTime(eventRequest.getStartDateTime());
        event.setEventEndDateTime(eventRequest.getEndDateTime());
        event.setOrganizer(organizer);

        LOGGER.info("Event updated: {}", event);

        Event savedEvent = eventRepository.save(event);
        return new EventResponse(savedEvent);

    }

    @Override
    public void deleteEvent(Long eventId) throws NotFoundException {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Event not found"));
        eventRepository.delete(event);
    }

    @Override
    public EventResponse getEvent(Long eventId) throws NotFoundException {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException("Event not found"));
        return new EventResponse(event);
    }

    @Override
    public List<EventResponse> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return EventResponse.fromEvents(events);
    }

}
