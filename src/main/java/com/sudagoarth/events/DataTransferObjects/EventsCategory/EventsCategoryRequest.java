package com.sudagoarth.events.DataTransferObjects.EventsCategory;


import jakarta.validation.constraints.NotBlank;

public class EventsCategoryRequest {

    private Long id;

    @NotBlank(message = "Event category name is required")
    private String name; 


    public EventsCategoryRequest() {}

    public EventsCategoryRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public EventsCategoryRequest(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return id;
    }

    public void setgetCategoryId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
