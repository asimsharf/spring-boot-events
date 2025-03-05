package com.sudagoarth.events.DataTransferObjects.EventsCategory;

import java.util.ArrayList;
import java.util.List;

import com.sudagoarth.events.DataTransferObjects.Event.EventResponse;
import com.sudagoarth.events.Models.EventsCategory;

public class EventsCategoryResponse {
    private Long id;
    private String name;
    private List<EventResponse> events;

    public EventsCategoryResponse() {
    }

    public EventsCategoryResponse(Long id, String name, List<EventResponse> events) {
        this.id = id;
        this.name = name;
        this.events = events;
    }

 public static EventsCategoryResponse fromEntity(EventsCategory eventsCategory) {
    List<EventResponse> eventResponses = (eventsCategory.getEvents() == null ? 
        new ArrayList<>() : eventsCategory.getEvents().stream()
            .map(EventResponse::fromEntity)
            .toList());

    return new EventsCategoryResponse(eventsCategory.getCategoryId(), eventsCategory.getName(), eventResponses);
}


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EventResponse> getEvents() {
        return events;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEvents(List<EventResponse> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventsCategoryResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", events=" + events +
                '}';
    }
}
