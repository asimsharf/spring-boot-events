package com.sudagoarth.events.UploadedFile.Services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.Event.Services.EventsService;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.UploadedFileRequest;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.UploadedFileResponse;
import com.sudagoarth.events.UploadedFile.Interfaces.UploadedFileInterface;
import com.sudagoarth.events.User.Repositories.UploadedFileRepository;

@Service
public class UploadedFileService implements UploadedFileInterface {

    @Autowired
    private UploadedFileRepository uploadedFileRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsService.class);

    @Override
    public List<UploadedFileResponse> getAllUploadedFiles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUploadedFiles'");
    }

    @Override
    public UploadedFileResponse getUploadedFileById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUploadedFileById'");
    }

    @Override
    public UploadedFileResponse createUploadedFile(UploadedFileRequest uploadedFileRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUploadedFile'");
    }

    @Override
    public UploadedFileResponse updateUploadedFile(Long id, UploadedFileRequest uploadedFileRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUploadedFile'");
    }

    @Override
    public void deleteUploadedFile(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUploadedFile'");
    }

}
