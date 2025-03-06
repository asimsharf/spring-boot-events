package com.sudagoarth.events.UploadedFile.Interfaces;

import java.util.List;

import com.sudagoarth.events.UploadedFile.DataTransferObjects.RequiredDocumentRequest;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.RequiredDocumentResponse;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.UploadedFileRequest;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.UploadedFileResponse;



public interface UploadedFileInterface {
    List<UploadedFileResponse> getAllUploadedFiles();

    UploadedFileResponse getUploadedFileById(Long id);

    UploadedFileResponse createUploadedFile( UploadedFileRequest uploadedFileRequest);

    UploadedFileResponse updateUploadedFile(Long id, UploadedFileRequest uploadedFileRequest);

    void deleteUploadedFile(Long id);

    List<RequiredDocumentResponse> getAllRequiredDocuments(Long entityType);

    RequiredDocumentResponse getRequiredDocumentById(Long id);

    RequiredDocumentResponse createRequiredDocument(RequiredDocumentRequest requiredDocumentRequest);

    RequiredDocumentResponse updateRequiredDocument(Long id, RequiredDocumentRequest requiredDocumentRequest);

    void deleteRequiredDocument(Long id);
}
