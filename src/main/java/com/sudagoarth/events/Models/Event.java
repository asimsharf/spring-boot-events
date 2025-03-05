package com.sudagoarth.events.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_name", nullable = false, unique = true, length = 100)
    private String eventName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private EventsCategory category; // Each event belongs to one category

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_location_id", nullable = false)
    private Location eventLocation;

    private LocalDateTime eventStartDateTime;
    private LocalDateTime eventEndDateTime;
    private String eventImageUrl;
    private double eventDistance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;

    public Event() {
    }

    public Event(Long id, String eventName, EventsCategory category, Location eventLocation,
            LocalDateTime eventStartDateTime, LocalDateTime eventEndDateTime, String eventImageUrl,
            double eventDistance, Organizer organizer) {
        this.id = id;
        this.eventName = eventName;
        this.category = category;
        this.eventLocation = eventLocation;
        this.eventStartDateTime = eventStartDateTime;
        this.eventEndDateTime = eventEndDateTime;
        this.eventImageUrl = eventImageUrl;
        this.eventDistance = eventDistance;
        this.organizer = organizer;
    }

    public Event(String eventName, EventsCategory category, Location eventLocation, LocalDateTime eventStartDateTime,
            LocalDateTime eventEndDateTime, String eventImageUrl, double eventDistance, Organizer organizer) {
        this.eventName = eventName;
        this.category = category;
        this.eventLocation = eventLocation;
        this.eventStartDateTime = eventStartDateTime;
        this.eventEndDateTime = eventEndDateTime;
        this.eventImageUrl = eventImageUrl;
        this.eventDistance = eventDistance;
        this.organizer = organizer;
    }

    public Long getEventId() {
        return id;
    }

    public void setEventId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public EventsCategory getEventCategory() {
        return category;
    }

    public void setEventCategory(EventsCategory category) {
        this.category = category;
    }

    public Location getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(Location eventLocation) {
        this.eventLocation = eventLocation;
    }

    public LocalDateTime getEventStartDateTime() {
        return eventStartDateTime;
    }

    public void setEventStartDateTime(LocalDateTime eventStartDateTime) {
        this.eventStartDateTime = eventStartDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public void setEventEndDateTime(LocalDateTime eventEndDateTime) {
        this.eventEndDateTime = eventEndDateTime;
    }

    public String getEventImageUrl() {
        return eventImageUrl;
    }

    public void setEventImageUrl(String eventImageUrl) {
        this.eventImageUrl = eventImageUrl;
    }

    public double getEventDistance() {
        return eventDistance;
    }

    public void setEventDistance(double eventDistance) {
        this.eventDistance = eventDistance;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", category=" + category.toString() +
                ", eventLocation=" + eventLocation.toString() +
                ", eventStartDateTime=" + eventStartDateTime +
                ", eventEndDateTime=" + eventEndDateTime +
                ", eventImageUrl='" + eventImageUrl + '\'' +
                ", eventDistance=" + eventDistance +
                ", organizer=" + organizer.toString() +
                '}';
    }
}
