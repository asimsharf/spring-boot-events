package com.sudagoarth.events.Models;


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
    private Long organizerId;

    private String organizerName;
    private String organizerEmail;
    private String organizerPhone;
    private String organizerWebsite;
    private String organizerLogoUrl;

    @ManyToOne
    @JoinColumn(name = "organizer_location_id", nullable = false)
    private Location organizerLocation;

    // Getters and Setters
    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerPhone() {
        return organizerPhone;
    }

    public void setOrganizerPhone(String organizerPhone) {
        this.organizerPhone = organizerPhone;
    }

    public String getOrganizerWebsite() {
        return organizerWebsite;
    }

    public void setOrganizerWebsite(String organizerWebsite) {
        this.organizerWebsite = organizerWebsite;
    }

    public String getOrganizerLogoUrl() {
        return organizerLogoUrl;
    }

    public void setOrganizerLogoUrl(String organizerLogoUrl) {
        this.organizerLogoUrl = organizerLogoUrl;
    }

    public Location getOrganizerLocation() {
        return organizerLocation;
    }

    public void setOrganizerLocation(Location organizerLocation) {
        this.organizerLocation = organizerLocation;
    }
}
