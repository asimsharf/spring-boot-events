package com.sudagoarth.events.Services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.DataTransferObjects.EventsCategory.EventsCategoryRequest;
import com.sudagoarth.events.Interfaces.EventsCategoryInterface;
import com.sudagoarth.events.Models.EventsCategory;
import com.sudagoarth.events.Repositories.EventsCategoryRepository;
import com.sudagoarth.events.exceptions.EventsCategoryNotFoundException;

@Service
public class EventsCategoryService implements EventsCategoryInterface {

    @Autowired
    private EventsCategoryRepository eventsCategoryRepository;

    private static final Logger LOGGER = Logger.getLogger(EventsCategoryService.class.getName());


    @Override
    public EventsCategory createEventCategory(EventsCategoryRequest eventsCategoryRequest) {    
        LOGGER.info("Creating event category");
        EventsCategory eventsCategory = new EventsCategory();
        eventsCategory.setName(eventsCategoryRequest.getName());
        return eventsCategoryRepository.save(eventsCategory);
    }

    @Override
    public EventsCategory updateEventCategory(EventsCategoryRequest eventsCategoryRequest) throws EventsCategoryNotFoundException {

    
        // Check if the category exists by id
        if (eventsCategoryRequest.getCategoryId() == null) {
            throw new IllegalArgumentException("Event category ID is required for update");
        }
    
        // Fetch the existing category from the repository
        EventsCategory existingCategory = eventsCategoryRepository.findById(eventsCategoryRequest.getCategoryId())
                .orElseThrow(() -> new EventsCategoryNotFoundException("Event category not found with id: " + eventsCategoryRequest.getCategoryId()));
    
        // Log if category found
    
        // Update the existing category fields
        existingCategory.setName(eventsCategoryRequest.getName());
        
        // Save the updated category back to the database
        EventsCategory updatedCategory = eventsCategoryRepository.save(existingCategory);
 
        
        return updatedCategory;
    }
    


    @Override
    public EventsCategory deleteEventCategory(Long eventCategoryId)  {
        LOGGER.info("Deleting event category");
        EventsCategory eventsCategory = eventsCategoryRepository.findById(eventCategoryId).orElse(null);
        if (eventsCategory != null) {
            eventsCategoryRepository.delete(eventsCategory);
        }
        return eventsCategory;
    }


    @Override
    public EventsCategory getEventCategory(Long eventCategoryId) {
        LOGGER.info("Getting event category");
        return eventsCategoryRepository.findById(eventCategoryId).orElse(null);
    }


    @Override
    public List<EventsCategory> getAllEventCategories() {
        LOGGER.info("Getting all event categories");
        return eventsCategoryRepository.findAll();
    }


}
