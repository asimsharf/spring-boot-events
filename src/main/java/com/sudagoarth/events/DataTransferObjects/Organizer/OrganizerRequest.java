package com.sudagoarth.events.DataTransferObjects.Organizer;

import com.sudagoarth.events.DataTransferObjects.Location.LocationRequest;

import jakarta.validation.constraints.NotBlank;

public class OrganizerRequest {

    @NotBlank(message = "Organizer email is required")
    private String email;

    @NotBlank(message = "Organizer logo URL is required")
    private String logoUrl;

    @NotBlank(message = "Organizer name is required")
    private String name;

    @NotBlank(message = "Organizer phone is required")
    private String phone;

    @NotBlank(message = "Organizer website is required")
    private String website;

    @NotBlank(message = "Organizer location is required")
    private LocationRequest location;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public LocationRequest getLocation() {
        return location;
    }

    public void setLocation(LocationRequest location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "OrganizerRequest [email=" + email + ", location=" + location + ", logoUrl=" + logoUrl + ", name=" + name
                + ", phone=" + phone + ", website=" + website + "]";
    }
    
}
