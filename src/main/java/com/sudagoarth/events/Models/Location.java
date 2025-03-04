package com.sudagoarth.events.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

import com.sudagoarth.events.DataTransferObjects.Location.LocationRequest;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    private double latitude;
    private double longitude;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    // Constructors
    public Location() {
    }

    public Location(double latitude, double longitude, String address, String city, String state, String country, String postalCode) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public Location(LocationRequest locationRequest) {
        this.latitude = locationRequest.getLatitude();
        this.longitude = locationRequest.getLongitude();
        this.address = locationRequest.getAddress();
        this.city = locationRequest.getCity();
        this.state = locationRequest.getState();
        this.country = locationRequest.getCountry();
        this.postalCode = locationRequest.getPostalCode();
    }

    // Getters and Setters
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
