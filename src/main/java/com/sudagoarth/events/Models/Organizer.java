package com.sudagoarth.events.Models;

import com.sudagoarth.events.DataTransferObjects.Organizer.OrganizerRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "organizer")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String website;
    private String logoUrl;

    @ManyToOne
    @JoinColumn(name = "organizer_location_id", nullable = false)
    private Location location;

    public Organizer() {
    }

    public Organizer(OrganizerRequest organizerRequest, Location location) {
        this.name = organizerRequest.getName();
        this.email = organizerRequest.getEmail();
        this.phone = organizerRequest.getPhone();
        this.website = organizerRequest.getWebsite();
        this.logoUrl = organizerRequest.getLogoUrl();
        this.location = location;
    }

    public Organizer(String name, String email, String phone, String website, String logoUrl, Location location) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.logoUrl = logoUrl;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Organizer [email=" + email + ", id=" + id + ", location=" + location.toString() + ", logoUrl=" + logoUrl
                + ", name="
                + name + ", phone=" + phone + ", website=" + website + "]";
    }

}
