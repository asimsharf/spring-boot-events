package com.sudagoarth.events.Location.DataTransferObjects;

import com.sudagoarth.events.Location.Entities.Location;

public class LocationRequest {
    private String address;
    private String city;
    private String country;
    private double latitude;
    private double longitude;
    private String postalCode;
    private String state;

    public LocationRequest() {
    }

    public LocationRequest(String address, String city, String country, double latitude, double longitude,
            String postalCode, String state) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.state = state;
    }

    public static LocationRequest fromEntity(Location location) {
        return new LocationRequest(location.getAddress(), location.getCity(), location.getCountry(),
                location.getLatitude(), location.getLongitude(), location.getPostalCode(), location.getState());
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "LocationRequest [address=" + address + ", city=" + city + ", country=" + country + ", latitude="
                + latitude
                + ", longitude=" + longitude + ", postalCode=" + postalCode + ", state=" + state + "]";
    }
}
