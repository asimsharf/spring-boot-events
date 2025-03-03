package com.sudagoarth.events.DataTransferObjects.Event;

import com.sudagoarth.events.DataTransferObjects.Location.LocationRequest;
import com.sudagoarth.events.DataTransferObjects.Organizer.OrganizerRequest;
import com.sudagoarth.events.Models.EventsCategory;

import jakarta.validation.constraints.NotBlank;

public class EventRequest {
    @NotBlank(message = "Event name is required")
    private String name;
    @NotBlank(message = "Start date and time is required")
    private String startDateTime;
    @NotBlank(message = "End date and time is required")
    private String endDateTime;

    @NotBlank(message = "Event image URL is required")
    private String eventImageUrl;

    @NotBlank(message = "Event category is required")
    private EventsCategory category;

    @NotBlank(message = "Event location is required")
    private LocationRequest location;

    @NotBlank(message = "Event organizer is required")
    private OrganizerRequest organizer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
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
}
