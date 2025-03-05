package com.sudagoarth.events.DataTransferObjects.UploadedFile;


public class UploadedFileRequest {
    private String fileName;
    private String filePath;
    private Long fileSize;

    public UploadedFileRequest() {
    }

    public UploadedFileRequest(String fileName, String filePath, Long fileSize) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
}