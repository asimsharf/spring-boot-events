package com.sudagoarth.events.Interfaces;

import java.util.List;

import com.sudagoarth.events.DataTransferObjects.UploadedFile.UploadedFileRequest;
import com.sudagoarth.events.DataTransferObjects.UploadedFile.UploadedFileResponse;

public interface UploadedFileInterface {
    List<UploadedFileResponse> getAllUploadedFiles();

    UploadedFileResponse getUploadedFileById(Long id);

    UploadedFileResponse createUploadedFile(UploadedFileRequest uploadedFileRequest);

    UploadedFileResponse updateUploadedFile(Long id, UploadedFileRequest uploadedFileRequest);

    void deleteUploadedFile(Long id);
}
