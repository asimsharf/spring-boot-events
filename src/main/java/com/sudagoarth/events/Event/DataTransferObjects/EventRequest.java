package com.sudagoarth.events.Event.DataTransferObjects;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sudagoarth.events.Event.Entities.EventsCategory;
import com.sudagoarth.events.Location.DataTransferObjects.LocationRequest;
import com.sudagoarth.events.Organizer.DataTransferObjects.OrganizerRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EventRequest {

    private Long id;

    @NotBlank(message = "Event name is required")
    private String name;

    @NotNull(message = "Start date and time is required")
    @NotBlank(message = "Start date and time is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDateTime;

    @NotNull(message = "End date and time is required")
    @NotBlank(message = "End date and time is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDateTime;

    @NotBlank(message = "Event image URL is required")
    private String eventImageUrl;

    @NotBlank(message = "Event category is required")
    private EventsCategory category;

    @NotBlank(message = "Event location is required")
    private LocationRequest location;

    @NotBlank(message = "Event organizer is required")
    private OrganizerRequest organizer;

    public EventRequest() {
    }

    public EventRequest(Long id, String name, LocalDateTime startDateTime, LocalDateTime endDateTime,
            String eventImageUrl,
            EventsCategory category, LocationRequest location, OrganizerRequest organizer) {
        this.id = id;
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.eventImageUrl = eventImageUrl;
        this.category = category;
        this.location = location;
        this.organizer = organizer;
    }

    public EventRequest(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String eventImageUrl,
            EventsCategory category, LocationRequest location, OrganizerRequest organizer) {
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.eventImageUrl = eventImageUrl;
        this.category = category;
        this.location = location;
        this.organizer = organizer;
    }

    public EventRequest(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String eventImageUrl,
            EventsCategory category, LocationRequest location, OrganizerRequest organizer, Long id) {
        this.id = id;
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.eventImageUrl = eventImageUrl;
        this.category = category;
        this.location = location;
        this.organizer = organizer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
    }

    public EventsCategory getCategory() {
        return category;
    }

    public void setCategory(EventsCategory category) {
        this.category = category;
    }

    public LocationRequest getLocation() {
        return location;
    }

    public void setLocation(LocationRequest location) {
        this.location = location;
    }

    public OrganizerRequest getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerRequest organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "EventRequest [category=" + category.toString() + ", endDateTime=" + endDateTime + ", eventImageUrl="
                + eventImageUrl
                + ", location=" + location.toString() + ", name=" + name + ", organizer=" + organizer.toString()
                + ", startDateTime="
                + startDateTime + "]";
    }
}
