package com.sudagoarth.events.Event.DataTransferObjects;

import java.time.LocalDateTime;
import java.util.List;

import com.sudagoarth.events.Event.Entities.Event;
import com.sudagoarth.events.Location.DataTransferObjects.LocationResponse;
import com.sudagoarth.events.Organizer.DataTransferObjects.OrganizerResponse;

public class EventResponse {
    private Long id;
    private String eventName;
    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private String eventImageUrl;
    private double eventDistance;
    private EventsCategoryResponse category;
    private LocationResponse eventLocation;
    private OrganizerResponse organizer;

    public EventResponse() {
    }

    public EventResponse(Long id, String eventName, LocalDateTime eventStartDateTime, LocalDateTime eventEndDateTime,
            String eventImageUrl, double eventDistance, LocationResponse eventLocation, OrganizerResponse organizer) {
        this.id = id;
        this.eventName = eventName;
        this.eventStartDateTime = eventStartDateTime;
        this.eventEndDateTime = eventEndDateTime;
        this.eventImageUrl = eventImageUrl;
        this.eventDistance = eventDistance;
        this.eventLocation = eventLocation;
        this.organizer = organizer;
    }

    public EventResponse(Event savedEvent) {
        this.id = savedEvent.getEventId();
        this.eventName = savedEvent.getEventName();
        this.eventStartDateTime = savedEvent.getEventStartDateTime();
        this.eventEndDateTime = savedEvent.getEventEndDateTime();
        this.eventImageUrl = savedEvent.getEventImageUrl();
        this.eventDistance = savedEvent.getEventDistance();
        this.category = EventsCategoryResponse.fromEntity(savedEvent.getEventCategory());
        this.eventLocation = LocationResponse.fromEntity(savedEvent.getEventLocation());
        this.organizer = OrganizerResponse.fromEntity(savedEvent.getOrganizer());
    }

    public static EventResponse fromEntity(Event event) {
        return new EventResponse(event.getEventId(), event.getEventName(), event.getEventStartDateTime(),
                event.getEventEndDateTime(), event.getEventImageUrl(), event.getEventDistance(),
                LocationResponse.fromEntity(event.getEventLocation()),
                OrganizerResponse.fromEntity(event.getOrganizer()));
    }

    public static List<EventResponse> fromEvents(List<Event> events) {
        return events.stream().map(EventResponse::fromEntity).toList();
    }

    public Long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDateTime getEventStartDateTime() {
        return eventStartDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public double getEventDistance() {
        return eventDistance;
    }

    public EventsCategoryResponse getCategory() {
        return category;
    }

    public LocationResponse getEventLocation() {
        return eventLocation;
    }

    public OrganizerResponse getOrganizer() {
        return organizer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
        this.eventStartDateTime = eventStartDateTime;
    }

    public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
        this.eventEndDateTime = eventEndDateTime;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
    }

    public void setEventDistance(double eventDistance) {
        this.eventDistance = eventDistance;
    }

    public void setCategory(EventsCategoryResponse category) {
        this.category = category;
    }

    public void setEventLocation(LocationResponse eventLocation) {
        this.eventLocation = eventLocation;
    }

    public void setOrganizer(OrganizerResponse organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventStartDateTime=" + eventStartDateTime +
                ", eventEndDateTime=" + eventEndDateTime +
                ", eventImageUrl='" + eventImageUrl + '\'' +
                ", eventDistance=" + eventDistance +
                ", category=" + category +
                ", eventLocation=" + eventLocation +
                ", organizer=" + organizer +
                '}';
    }

}
