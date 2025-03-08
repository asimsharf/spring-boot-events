package com.sudagoarth.events.UploadedFile.Services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sudagoarth.events.Event.Services.EventsService;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.RequiredDocumentRequest;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.RequiredDocumentResponse;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.UploadedFileRequest;
import com.sudagoarth.events.UploadedFile.DataTransferObjects.UploadedFileResponse;
import com.sudagoarth.events.UploadedFile.Entities.RequiredDocument;
import com.sudagoarth.events.UploadedFile.Entities.UploadedFile;
import com.sudagoarth.events.UploadedFile.Interfaces.UploadedFileInterface;
import com.sudagoarth.events.UploadedFile.Repositories.RequiredDocumentRepository;
import com.sudagoarth.events.UploadedFile.Repositories.UploadedFileRepository;
import com.sudagoarth.events.exceptions.NotFoundException;

@Service
public class UploadedFileService implements UploadedFileInterface {

    @Autowired
    private UploadedFileRepository uploadedFileRepository;

    @Autowired
    private RequiredDocumentRepository requiredDocumentRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventsService.class);

    @Override
    public List<UploadedFileResponse> getAllUploadedFiles() {

        List<UploadedFile> uploadedFiles = uploadedFileRepository.findAll();

        return UploadedFileResponse.fromUploadedFiles(uploadedFiles);
    }

    @Override
    public UploadedFileResponse getUploadedFileById(Long id) throws NotFoundException {
        UploadedFile uploadedFile = uploadedFileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Uploaded file not found with id: " + id));

        return new UploadedFileResponse(uploadedFile);
    }

    @Override
    public UploadedFileResponse createUploadedFile(UploadedFileRequest uploadedFileRequest) throws NotFoundException {

        // Decode the base64 string into bytes using Java's standard Base64
        String base64Data = uploadedFileRequest.getBase64File();

        // Remove the prefix if it exists (e.g., "data:image/png;base64,")
        if (base64Data.startsWith("data:")) {
            base64Data = base64Data.substring(base64Data.indexOf(",") + 1); // Remove the "data:[<mediatype>];base64,"
                                                                            // part
        }

        // Now decode the base64 string
        byte[] fileData = Base64.getDecoder().decode(base64Data);

        // Detect file type using Apache Tika (MIME type detection)
        Tika tika = new Tika();
        String mimeType = tika.detect(fileData); // This will give us the MIME type

        // Map MIME type to file extension
        String fileExtension = getExtensionFromMimeType(mimeType);
        if (fileExtension == null) {
            throw new RuntimeException("Unsupported file type: " + mimeType);
        }

        // Define the directory and path where the file will be stored
        String directoryPath = "uploads/" + uploadedFileRequest.getRequiredDocumentId();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directories if they do not exist
        }

        // Generate a file name with the extension
        String fileName = uploadedFileRequest.getFileName() + "." + fileExtension;
        String filePath = directoryPath + "/" + fileName;

        // Fetch the RequiredDocument entity using the provided ID
        RequiredDocument requiredDocument = requiredDocumentRepository
                .findById(uploadedFileRequest.getRequiredDocumentId())
                .orElseThrow(() -> new NotFoundException(
                        "Required document not found with id: " + uploadedFileRequest.getRequiredDocumentId()));

        // Check if the file already exists for the given RequiredDocument
        UploadedFile existingFile = uploadedFileRepository.findByRequiredDocument(requiredDocument);

        UploadedFile uploadedFile;
        if (existingFile != null) {
            // If a file already exists, delete the old file in the directory
            File oldFile = new File(existingFile.getFilePath());
            if (oldFile.exists()) {
                oldFile.delete(); // Delete the old file
            }

            // Update the existing file
            existingFile.setFileName(fileName);
            existingFile.setFilePath(filePath);
            existingFile.setFileSize((long) fileData.length);
            existingFile.setFileExtension(fileExtension);

            // Save the updated file details
            uploadedFile = uploadedFileRepository.save(existingFile); // Update the existing file in the database
        } else {
            // If no file exists, create a new file
            UploadedFile fileEntity = new UploadedFile();
            fileEntity.setFileName(fileName);
            fileEntity.setFilePath(filePath);
            fileEntity.setFileSize((long) fileData.length);
            fileEntity.setFileExtension(fileExtension);
            fileEntity.setRequiredDocument(requiredDocument); // Set the actual RequiredDocument entity

            uploadedFile = uploadedFileRepository.save(fileEntity); // Save as a new file
        }

        // Save the new file on disk (after removing the old one, if it existed)
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(fileData); // Write the new file data to the file
        } catch (IOException e) {
            throw new RuntimeException("Error writing file to disk: " + e.getMessage(), e);
        }

        // Return the response with the file details
        return new UploadedFileResponse(uploadedFile);
    }

    // Helper method to get file extension from MIME type
    private String getExtensionFromMimeType(String mimeType) {
        switch (mimeType) {
            case "image/jpeg":
                return "jpg";
            case "image/png":
                return "png";
            case "application/pdf":
                return "pdf";
            case "application/msword":
                return "doc";
            case "application/vnd.openxmlformats-officedocument.wordprocessingml.document":
                return "docx";
            case "application/vnd.ms-excel":
                return "xls";
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
                return "xlsx";
            case "application/zip":
                return "zip";
            case "text/plain":
                return "txt";
            default:
                return null; // Unknown mime type
        }
    }

    @Override
    public UploadedFileResponse updateUploadedFile(Long id, UploadedFileRequest uploadedFileRequest)
            throws NotFoundException {

        // Fetch the existing uploaded file entity
        UploadedFile uploadedFile = uploadedFileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Uploaded file not found with id: " + id));

        // Decode the base64 string into bytes using Java's standard Base64
        String base64Data = uploadedFileRequest.getBase64File();

        // Remove the prefix if it exists (e.g., "data:image/png;base64,")
        if (base64Data.startsWith("data:")) {
            base64Data = base64Data.substring(base64Data.indexOf(",") + 1); // Remove the "data:[<mediatype>];base64,"
                                                                            // part
        }

        // Now decode the base64 string
        byte[] fileData = Base64.getDecoder().decode(base64Data);

        // Detect file type using Apache Tika (MIME type detection)
        Tika tika = new Tika();
        String mimeType = tika.detect(fileData); // This will give us the MIME type

        // Map MIME type to file extension
        String fileExtension = getExtensionFromMimeType(mimeType);
        if (fileExtension == null) {
            throw new RuntimeException("Unsupported file type: " + mimeType);
        }

        // Define the directory and path where the file will be stored
        String directoryPath = "uploads/" + uploadedFileRequest.getRequiredDocumentId();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs(); // Create directories if they do not exist
        }

        // Generate a file name with the extension
        String fileName = uploadedFileRequest.getFileName() + "." + fileExtension;
        String filePath = directoryPath + "/" + fileName;

        // Fetch the RequiredDocument entity using the provided ID
        RequiredDocument requiredDocument = requiredDocumentRepository
                .findById(uploadedFileRequest.getRequiredDocumentId())
                .orElseThrow(() -> new NotFoundException(
                        "Required document not found with id: " + uploadedFileRequest.getRequiredDocumentId()));

        // Check if the file already exists for the given RequiredDocument
        UploadedFile existingFile = uploadedFileRepository.findByRequiredDocument(requiredDocument);

        if (existingFile != null) {
            // If a file already exists, delete the old file in the directory
            File oldFile = new File(existingFile.getFilePath());
            if (oldFile.exists()) {
                oldFile.delete(); // Delete the old
            }
        }

        // Update the existing file
        uploadedFile.setFileName(fileName);
        uploadedFile.setFilePath(filePath);
        uploadedFile.setFileSize((long) fileData.length);
        uploadedFile.setFileExtension(fileExtension);
        uploadedFile.setRequiredDocument(requiredDocument); // Set the actual RequiredDocument entity

        // Save the updated file details
        UploadedFile updatedFile = uploadedFileRepository.save(uploadedFile); // Update the existing file in the
                                                                              // database

        // Save the new file on disk (after removing the old one, if it existed)
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(fileData); // Write the new file data to the file
        } catch (IOException e) {
            throw new RuntimeException("Error writing file to disk: " + e.getMessage(), e);
        }

        // Return the response with the file details
        return new UploadedFileResponse(updatedFile);

    }

    @Override
    public void deleteUploadedFile(Long id) throws NotFoundException {
        UploadedFile uploadedFile = uploadedFileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Uploaded file not found with id: " + id));

        // Delete the file from the disk
        File file = new File(uploadedFile.getFilePath());
        if (file.exists()) {
            file.delete(); // Delete the file
        }

        // Delete the file from the database
        uploadedFileRepository.delete(uploadedFile);
    }

    @Override
    public List<RequiredDocumentResponse> getAllRequiredDocuments(Long entityTypeId) throws NotFoundException {
        LOGGER.info("Fetching all required documents for entityTypeId: {}", entityTypeId);

        // Fetch required documents for the given entityTypeId
        List<RequiredDocument> requiredDocuments = requiredDocumentRepository.findByEntityType(entityTypeId);

        // Filter out the documents that have already been uploaded
        List<RequiredDocument> documentsToReturn = requiredDocuments.stream()
                .filter(requiredDocument -> !uploadedFileRepository.existsByRequiredDocument(requiredDocument))
                .collect(Collectors.toList());

        return RequiredDocumentResponse.fromEntities(documentsToReturn);
    }

    @Override
    public RequiredDocumentResponse getRequiredDocumentById(Long id) throws NotFoundException {
        RequiredDocument requiredDocument = requiredDocumentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Required document not found with id: " + id));

        return new RequiredDocumentResponse(requiredDocument);
    }

    @Override
    public RequiredDocumentResponse createRequiredDocument(RequiredDocumentRequest requiredDocumentRequest) {
        RequiredDocument requiredDocument = new RequiredDocument();
        requiredDocument.setDocumentName(requiredDocumentRequest.getDocumentName());
        requiredDocument.setEntityType(requiredDocumentRequest.getEntityType());
        requiredDocument.setRequired(requiredDocumentRequest.isRequired());

        RequiredDocument savedDocument = requiredDocumentRepository.save(requiredDocument);

        return new RequiredDocumentResponse(savedDocument);
    }

    @Override
    public RequiredDocumentResponse updateRequiredDocument(Long id, RequiredDocumentRequest requiredDocumentRequest)
            throws NotFoundException {
        RequiredDocument requiredDocument = requiredDocumentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Required document not found with id: " + id));

        requiredDocument.setDocumentName(requiredDocumentRequest.getDocumentName());
        requiredDocument.setEntityType(requiredDocumentRequest.getEntityType());
        requiredDocument.setRequired(requiredDocumentRequest.isRequired());

        RequiredDocument updatedDocument = requiredDocumentRepository.save(requiredDocument);

        return new RequiredDocumentResponse(updatedDocument);
    }

    @Override
    public void deleteRequiredDocument(Long id) throws NotFoundException {
        RequiredDocument requiredDocument = requiredDocumentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Required document not found with id: " + id));

        requiredDocumentRepository.delete(requiredDocument);
    }

}
