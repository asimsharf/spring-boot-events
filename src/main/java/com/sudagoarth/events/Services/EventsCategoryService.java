package com.sudagoarth.events.Services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.DataTransferObjects.EventsCategory.EventsCategoryRequest;
import com.sudagoarth.events.Interfaces.EventsCategoryInterface;
import com.sudagoarth.events.Models.EventsCategory;
import com.sudagoarth.events.Repositories.EventsCategoryRepository;
import com.sudagoarth.events.exceptions.DuplicateException;
import com.sudagoarth.events.exceptions.NotFoundException;

@Service
public class EventsCategoryService implements EventsCategoryInterface {

    @Autowired
    private EventsCategoryRepository eventsCategoryRepository;

    private static final Logger LOGGER = Logger.getLogger(EventsCategoryService.class.getName());

    @Override
    public EventsCategory createEventCategory(EventsCategoryRequest eventsCategoryRequest) throws DuplicateException {
        try {
            EventsCategory eventsCategory = new EventsCategory();
            eventsCategory.setName(eventsCategoryRequest.getName());
            return eventsCategoryRepository.save(eventsCategory);
        } catch (Exception ex) {
            throw new DuplicateException("Category already exists");
        }
    }

    @Override
    public EventsCategory updateEventCategory(EventsCategoryRequest eventsCategoryRequest) {
        // Ensure the category ID is provided
        if (eventsCategoryRequest.getId() == null) {
            throw new IllegalArgumentException("Event category ID is required for update.");
        }

        // Fetch the existing category from the repository
        EventsCategory existingCategory = eventsCategoryRepository.findById(eventsCategoryRequest.getId())
                .orElseThrow(() -> new NotFoundException(
                        "Event category not found with ID: " + eventsCategoryRequest.getId()));

        // Update the category name
        existingCategory.setName(eventsCategoryRequest.getName());

        try {
            // Save the updated category
            return eventsCategoryRepository.save(existingCategory);
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateException("Category with this name already exists.");
        }
    }

    @Override
    public void deleteEventCategory(Long eventCategoryId) throws NotFoundException {
        // Fetch the existing category from the repository
        EventsCategory existingCategory = eventsCategoryRepository.findById(eventCategoryId)
                .orElseThrow(() -> new NotFoundException("Event category not found with ID: " + eventCategoryId));

        // Delete the category
        eventsCategoryRepository.delete(existingCategory);
    }

    @Override
    public EventsCategory getEventCategory(Long eventCategoryId) throws NotFoundException {
        return eventsCategoryRepository.findById(eventCategoryId)
                .orElseThrow(() -> new NotFoundException("Event category not found with ID: " + eventCategoryId));
    }

    @Override
    public List<EventsCategory> getAllEventCategories() {
        LOGGER.info("Getting all event categories");
        return eventsCategoryRepository.findAll();
    }

}
