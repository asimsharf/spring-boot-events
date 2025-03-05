package com.sudagoarth.events.Event.Interfaces;

import java.util.List;

import com.sudagoarth.events.Event.DataTransferObjects.EventsCategoryRequest;
import com.sudagoarth.events.Event.Entities.EventsCategory;

public interface EventsCategoryInterface {
    EventsCategory createEventCategory(EventsCategoryRequest eventsCategoryRequest);

    EventsCategory updateEventCategory(EventsCategoryRequest eventsCategoryRequest);

    void deleteEventCategory(Long eventCategoryId);

    EventsCategory getEventCategory(Long eventCategoryId);

    List<EventsCategory> getAllEventCategories();
}
