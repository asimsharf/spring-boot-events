package com.sudagoarth.events.Models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_name", nullable = false, unique = true, length = 100)
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private EventsCategory category;  // Each event belongs to one category

    
    @ManyToOne
    @JoinColumn(name = "event_location_id", nullable = false)
    private Location eventLocation;

    private Date eventDate;
    private String eventTime;
    private String eventImageUrl;
    private double eventDistance;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;

    // Getters and Setters
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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
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
}
