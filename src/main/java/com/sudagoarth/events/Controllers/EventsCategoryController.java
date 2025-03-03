package com.sudagoarth.events.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudagoarth.events.DataTransferObjects.EventsCategory.EventsCategoryRequest;
import com.sudagoarth.events.Models.EventsCategory;
import com.sudagoarth.events.Models.LocaledData;
import com.sudagoarth.events.Services.EventsCategoryService;
import com.sudagoarth.events.exceptions.ApiResponse;

@RestController
@RequestMapping("/api/v1/events/categories")
public class EventsCategoryController {

    @Autowired
    private EventsCategoryService eventsCategoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsCategoryController.class.getName());

    @GetMapping
    public ResponseEntity<ApiResponse> getAllEventCategories() {
        LOGGER.info("Fetching all event categories");
        List<EventsCategory> eventsCategories = eventsCategoryService.getAllEventCategories();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(null, HttpStatus.OK.value(), eventsCategories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getEventCategory(@PathVariable Long id) {
        LOGGER.info("Fetching event category with ID: {}", id);
        EventsCategory eventsCategory = eventsCategoryService.getEventCategory(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(null, HttpStatus.OK.value(), eventsCategory));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createEventCategory(@RequestBody EventsCategoryRequest eventsCategoryRequest) {
        LOGGER.info("Creating event category");
        EventsCategory eventsCategory = eventsCategoryService.createEventCategory(eventsCategoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(null, HttpStatus.CREATED.value(), eventsCategory));
    }

    @PatchMapping
    public ResponseEntity<ApiResponse> updateEventCategory(@RequestBody EventsCategoryRequest eventsCategoryRequest) {
        LOGGER.info("Updating event category {}", eventsCategoryRequest.toString());
        EventsCategory eventsCategory = eventsCategoryService.updateEventCategory(eventsCategoryRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(null, HttpStatus.OK.value(), eventsCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEventCategory(@PathVariable Long id) {
        LOGGER.info("Deleting event category with ID: {}", id);
        eventsCategoryService.deleteEventCategory(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(
                        new LocaledData("تم حذف الفئة بنجاح.", "Category deleted successfully."),
                        HttpStatus.OK.value(),
                        null));
    }

}
