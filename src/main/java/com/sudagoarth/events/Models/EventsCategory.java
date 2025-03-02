package com.sudagoarth.events.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "events_category")
public class EventsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(nullable = false, unique = true)
    private String name;  // For example: "Music", "Art", etc.

    @OneToMany(mappedBy = "category")
    private List<Event> events;  // A category has many events

    // Getters and Setters
    public Long getCategoryId() {
        return id;
    }

    public void setCategoryId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
}
