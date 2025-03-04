package com.sudagoarth.events.DataTransferObjects.Event;

import java.time.LocalDateTime;

import com.sudagoarth.events.DataTransferObjects.EventsCategory.EventsCategoryResponse;
import com.sudagoarth.events.DataTransferObjects.Location.LocationResponse;
import com.sudagoarth.events.DataTransferObjects.Organizer.OrganizerResponse;

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

    public static EventResponse fromEntity(com.sudagoarth.events.Models.Event event) {
        return new EventResponse(event.getEventId(), event.getEventName(), event.getEventStartDateTime(),
                event.getEventEndDateTime(), event.getEventImageUrl(), event.getEventDistance(),
                LocationResponse.fromEntity(event.getEventLocation()),
                OrganizerResponse.fromEntity(event.getOrganizer()));
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
