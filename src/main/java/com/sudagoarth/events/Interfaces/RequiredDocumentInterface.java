package com.sudagoarth.events.Interfaces;

import java.util.List;

import com.sudagoarth.events.DataTransferObjects.RequiredDocument.RequiredDocumentRequest;
import com.sudagoarth.events.DataTransferObjects.RequiredDocument.RequiredDocumentResponse;

public interface RequiredDocumentInterface {
    List<RequiredDocumentResponse> getAllRequiredDocuments();

    RequiredDocumentResponse getRequiredDocumentById(Long id);

    RequiredDocumentResponse createRequiredDocument(RequiredDocumentRequest requiredDocumentRequest);

    RequiredDocumentResponse updateRequiredDocument(Long id, RequiredDocumentRequest requiredDocumentRequest);

    void deleteRequiredDocument(Long id);
}