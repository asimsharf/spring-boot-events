package com.sudagoarth.events.UploadedFile.Entities;

import com.sudagoarth.events.Event.Entities.EntityType;

import jakarta.persistence.*;

@Entity
public class RequiredDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entity_type_id")
    private EntityType entityType;

    private boolean isRequired;

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
