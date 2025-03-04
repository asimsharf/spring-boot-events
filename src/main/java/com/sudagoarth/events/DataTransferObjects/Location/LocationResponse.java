package com.sudagoarth.events.DataTransferObjects.Location;

import com.sudagoarth.events.Models.Location;

public class LocationResponse {
    private String address;
    private String city;
    private String country;
    private double latitude;
    private double longitude;
    private String postalCode;
    private String state;

    public LocationResponse() {
    }

    public LocationResponse(String address, String city, String country, double latitude, double longitude,
            String postalCode, String state) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.state = state;
    }

    public static LocationResponse fromEntity(Location localedData) {
        return new LocationResponse(localedData.getAddress(), localedData.getCity(), localedData.getCountry(),
                localedData.getLatitude(), localedData.getLongitude(), localedData.getPostalCode(),
                localedData.getState());
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getState() {
        return state;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LocationResponse{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
