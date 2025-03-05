package com.sudagoarth.events.Restaurant.Entities;

import com.sudagoarth.events.Location.Entities.Location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    private String restaurantName;
    private String restaurantCategory;

    @ManyToOne
    @JoinColumn(name = "restaurant_location_id", nullable = false)
    private Location restaurantLocation;

    private String restaurantImageUrl;
    private double restaurantDistance;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public Location getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(Location restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getRestaurantImageUrl() {
        return restaurantImageUrl;
    }

    public void setRestaurantImageUrl(String restaurantImageUrl) {
        this.restaurantImageUrl = restaurantImageUrl;
    }

    public double getRestaurantDistance() {
        return restaurantDistance;
    }

    public void setRestaurantDistance(double restaurantDistance) {
        this.restaurantDistance = restaurantDistance;
    }
}
