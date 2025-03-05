package com.sudagoarth.events.DataTransferObjects.UploadedFile;

import com.sudagoarth.events.Models.RequiredDocument;

public class UploadedFileResponse {

    private Long id;
    private String fileName;
    private String fileType;
    private String filePath;
    private Long fileSize;
    private String fileDownloadUri;
    private String fileExtension;
    private RequiredDocument requiredDocument;
    private boolean isRequired;

    public UploadedFileResponse() {
    }

    public UploadedFileResponse(Long id, String fileName, String fileType, String filePath, Long fileSize,
            String fileDownloadUri, String fileExtension, RequiredDocument requiredDocument, boolean isRequired) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileDownloadUri = fileDownloadUri;
        this.fileExtension = fileExtension;
        this.requiredDocument = requiredDocument;
        this.isRequired = isRequired;
    }

    public UploadedFileResponse(String fileName, String fileType, String filePath, Long fileSize,
            String fileDownloadUri, String fileExtension, RequiredDocument requiredDocument, boolean isRequired) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileDownloadUri = fileDownloadUri;
        this.fileExtension = fileExtension;
        this.requiredDocument = requiredDocument;
        this.isRequired = isRequired;
    }

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

    public void setRequired(boolean required) {
        isRequired = required;
    }

}
