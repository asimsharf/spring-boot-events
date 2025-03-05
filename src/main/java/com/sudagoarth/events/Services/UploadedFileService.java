package com.sudagoarth.events.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudagoarth.events.Interfaces.UploadedFileInterface;
import com.sudagoarth.events.Repositories.UploadedFileRepository;


@Service
public class UploadedFileService implements UploadedFileInterface {

    @Autowired
    private UploadedFileRepository uploadedFileRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsService.class);

}
