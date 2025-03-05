package com.sudagoarth.events.UploadedFile.Interfaces;

import java.util.List;

import com.sudagoarth.events.UploadedFile.DataTransferObjects.RequiredDocumentRequest;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.RequiredDocumentResponse;


public interface RequiredDocumentInterface {
    List<RequiredDocumentResponse> getAllRequiredDocuments();

    RequiredDocumentResponse getRequiredDocumentById(Long id);

    RequiredDocumentResponse createRequiredDocument(RequiredDocumentRequest requiredDocumentRequest);

    RequiredDocumentResponse updateRequiredDocument(Long id, RequiredDocumentRequest requiredDocumentRequest);

    void deleteRequiredDocument(Long id);
}