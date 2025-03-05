package com.sudagoarth.events.DataTransferObjects.RequiredDocument;

import com.sudagoarth.events.Models.EntityType;

import jakarta.validation.constraints.NotBlank;

public class RequiredDocumentRequest {
    private Long id;

    @NotBlank(message = "Document name is required")
    private String documentName;

    @NotBlank(message = "Entity type is required")
    private EntityType entityType;

    @NotBlank(message = "Required field is required")
    private boolean isRequired;

    public RequiredDocumentRequest() {
    }

    public RequiredDocumentRequest(Long id, String documentName, EntityType entityType, boolean isRequired) {
        this.id = id;
        this.documentName = documentName;
        this.entityType = entityType;
        this.isRequired = isRequired;
    }

    public RequiredDocumentRequest(String documentName, EntityType entityType, boolean isRequired) {
        this.documentName = documentName;
        this.entityType = entityType;
        this.isRequired = isRequired;
    }

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
