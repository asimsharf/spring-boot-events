package com.sudagoarth.events.UploadedFile.DataTransferObjects;

public class UploadedFileRequest {
    private Long requiredDocumentId;
    private String base64File;
    private String fileName;

    public UploadedFileRequest() {
    }

    public UploadedFileRequest(Long requiredDocumentId, String base64File, String fileName) {
        this.requiredDocumentId = requiredDocumentId;
        this.base64File = base64File;
        this.fileName = fileName;
    }

    public Long getRequiredDocumentId() {
        return requiredDocumentId;
    }

    public void setRequiredDocumentId(Long requiredDocumentId) {
        this.requiredDocumentId = requiredDocumentId;
    }

    public String getBase64File() {
        return base64File;
    }

    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }

    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
}