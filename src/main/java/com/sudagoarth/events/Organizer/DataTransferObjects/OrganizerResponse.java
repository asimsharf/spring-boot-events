package com.sudagoarth.events.Organizer.DataTransferObjects;

import com.sudagoarth.events.Location.DataTransferObjects.LocationRequest;
import com.sudagoarth.events.Organizer.Entities.Organizer;

public class OrganizerResponse {
    private String email;

    private String logoUrl;

    private String name;

    private String phone;

    private String website;

    private LocationRequest location;

    public OrganizerResponse() {
    }

    public OrganizerResponse(String email, String logoUrl, String name, String phone, String website,
            LocationRequest location) {
        this.email = email;
        this.logoUrl = logoUrl;
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.location = location;
    }

    public static OrganizerResponse fromEntity(Organizer organizer) {
        return new OrganizerResponse(organizer.getEmail(), organizer.getLogoUrl(), organizer.getName(),
                organizer.getPhone(), organizer.getWebsite(), LocationRequest.fromEntity(organizer.getLocation()));
    }

    public String getEmail() {
        return email;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public LocationRequest getLocation() {
        return location;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setLocation(LocationRequest location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "OrganizerResponse{" +
                "email='" + email + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", location=" + location +
                '}';
    }
}
