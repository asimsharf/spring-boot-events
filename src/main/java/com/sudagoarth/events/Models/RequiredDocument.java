package com.sudagoarth.events.Models;

import jakarta.persistence.*;

@Entity
public class RequiredDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentName;  // Name of the document (e.g., 'Event Image', 'Organizer Logo')

    @ManyToOne(fetch = FetchType.LAZY)  // Association to the entity (e.g., Event, Organizer)
    @JoinColumn(name = "entity_type_id")  // Foreign key to reference the entity type (e.g., Event, Organizer)
    private EntityType entityType;     // Reference to the entity type (Event, Organizer, etc.)

    private boolean isRequired;  // Whether the document is required for the associated entity

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }
}
