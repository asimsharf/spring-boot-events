package com.sudagoarth.events.UploadedFile.DataTransferObjects;

import java.util.List;

import com.sudagoarth.events.Event.Entities.EntityType;
import com.sudagoarth.events.UploadedFile.Entities.RequiredDocument;

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



    public RequiredDocumentResponse(RequiredDocument requiredDocument) {
        this.id = requiredDocument.getId();
        this.documentName = requiredDocument.getDocumentName();
        this.entityType = requiredDocument.getEntityType();
        this.isRequired = requiredDocument.isRequired();
    }

    public static List<RequiredDocumentResponse> fromEntities(List<RequiredDocument> requiredDocuments) {
        return requiredDocuments.stream().map(RequiredDocumentResponse::fromEntity).toList();
    }

    public static RequiredDocumentResponse fromEntity(RequiredDocument requiredDocument) {
        return new RequiredDocumentResponse(requiredDocument.getId(), requiredDocument.getDocumentName(), requiredDocument.getEntityType(), requiredDocument.isRequired());
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
