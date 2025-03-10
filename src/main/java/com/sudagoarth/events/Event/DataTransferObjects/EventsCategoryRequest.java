package com.sudagoarth.events.Event.DataTransferObjects;

import jakarta.validation.constraints.NotBlank;

public class EventsCategoryRequest {

    private Long id;

    @NotBlank(message = "Event category name is required")
    private String name;

    public EventsCategoryRequest() {
    }

    public EventsCategoryRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public EventsCategoryRequest(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "EventsCategoryRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
