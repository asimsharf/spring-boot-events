package com.sudagoarth.events.UploadedFile.DataTransferObjects;

import com.sudagoarth.events.Event.Entities.EntityType;

public class RequiredDocumentResponse {
    private Long id;
    private String documentName;
    private EntityType entityType;
    private boolean isRequired;

    public RequiredDocumentResponse() {
    }

    public RequiredDocumentResponse(Long id, String documentName, EntityType entityType, boolean isRequired) {
        this.id = id;
        this.documentName = documentName;
        this.entityType = entityType;
        this.isRequired = isRequired;
    }

    public RequiredDocumentResponse(String documentName, EntityType entityType, boolean isRequired) {
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
