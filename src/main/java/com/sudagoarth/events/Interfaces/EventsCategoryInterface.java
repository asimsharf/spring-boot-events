package com.sudagoarth.events.Interfaces;

import java.util.List;

import com.sudagoarth.events.DataTransferObjects.EventsCategory.EventsCategoryRequest;
import com.sudagoarth.events.Models.EventsCategory;

public interface EventsCategoryInterface {
    EventsCategory createEventCategory(EventsCategoryRequest eventsCategoryRequest);
    EventsCategory updateEventCategory(EventsCategoryRequest eventsCategoryRequest);
    EventsCategory deleteEventCategory(Long eventCategoryId);
    EventsCategory getEventCategory(Long eventCategoryId);
    List<EventsCategory> getAllEventCategories();
}

