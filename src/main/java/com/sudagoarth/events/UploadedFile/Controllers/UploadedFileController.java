package com.sudagoarth.events.UploadedFile.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sudagoarth.events.Entities.LocaledData;
import com.sudagoarth.events.Event.Controllers.EventsCategoryController;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.RequiredDocumentResponse;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.UploadedFileRequest;
import com.sudagoarth.events.UploadedFile.Interfaces.UploadedFileInterface;
import com.sudagoarth.events.exceptions.ApiResponse;

@RestController
@RequestMapping("/api/v1/uploaded-files")
public class UploadedFileController {

        @Autowired
        private UploadedFileInterface uploadedFileInterface;

        private static final Logger LOGGER = LoggerFactory.getLogger(EventsCategoryController.class.getName());

        @GetMapping("/required-documents")
        public ResponseEntity<ApiResponse> getAllRequiredDocuments(
                        @RequestParam(value = "entityTypeId", required = true) Long entityTypeId) {
                if (entityTypeId == null) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body(ApiResponse.error(new LocaledData(
                                                        "Required parameter 'entityTypeId' is missing",
                                                        "المعلمة المطلوبة 'entityTypeId' مفقودة"),
                                                        HttpStatus.BAD_REQUEST.value(),
                                                        "MISSING_PARAMETER", null));
                }

                LOGGER.info("Fetching all required documents for entityTypeId: {}", entityTypeId);
                List<RequiredDocumentResponse> requiredDocuments = uploadedFileInterface
                                .getAllRequiredDocuments(entityTypeId);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(ApiResponse.success(null, HttpStatus.OK.value(), requiredDocuments));
        }

        @PostMapping("/required-documents")
        public ResponseEntity<ApiResponse> createUploadedFile(
                        @RequestBody UploadedFileRequest uploadedFileRequest) {

                LOGGER.info("Creating new uploaded file for entityTypeId");
                uploadedFileInterface.createUploadedFile(uploadedFileRequest);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(ApiResponse.success(new LocaledData(
                                                "Uploaded file created successfully",
                                                "تم إنشاء الملف المرفوع بنجاح"),
                                                HttpStatus.OK.value(), null));

        }

    

}
