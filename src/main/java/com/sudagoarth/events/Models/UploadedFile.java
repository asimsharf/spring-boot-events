package com.sudagoarth.events.Models;

import jakarta.persistence.*;

@Entity
public class UploadedFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;  // The name of the file (e.g., 'event_image.jpg')

    @Column(nullable = false)
    private String fileType;  // The MIME type of the file (e.g., 'image/jpeg')

    @Column(nullable = false)
    private String filePath;  // Path to the file in storage (e.g., '/uploads/events/123.jpg')

    @Column(nullable = false)
    private Long fileSize;    // The size of the file in bytes

    private String fileDownloadUri;  // URI to download the file (e.g., 'http://example.com/uploads/events/123.jpg')

    private String fileExtension;    // Extension (e.g., 'jpg', 'png', 'pdf')

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "required_document_id")  // Foreign key to link the file to a required document
    private RequiredDocument requiredDocument;  // Reference to the associated required document (e.g., 'Event Image')

    private boolean isRequired;  // Whether the file is required for the associated entity

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public RequiredDocument getRequiredDocument() {
        return requiredDocument;
    }

    public void setRequiredDocument(RequiredDocument requiredDocument) {
        this.requiredDocument = requiredDocument;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }
}
