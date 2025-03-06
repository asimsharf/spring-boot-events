package com.sudagoarth.events.UploadedFile.DataTransferObjects;

import java.util.List;
import java.util.stream.Collectors;

import com.sudagoarth.events.UploadedFile.Entities.UploadedFile;

public class UploadedFileResponse {

    private Long id;

    private String fileName;

    private String filePath;

    private Long fileSize;

    private String fileExtension;

    public UploadedFileResponse() {
    }

    public UploadedFileResponse(Long id, String fileName, String filePath, Long fileSize,
            String fileExtension) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }

    public UploadedFileResponse(String fileName, String filePath, Long fileSize,
            String fileExtension) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }

    public UploadedFileResponse(UploadedFile uploadedFile) {
        this.id = uploadedFile.getId();
        this.fileName = uploadedFile.getFileName();
        this.filePath = uploadedFile.getFilePath();
        this.fileSize = uploadedFile.getFileSize();
        this.fileExtension = uploadedFile.getFileExtension();

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

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public static List<UploadedFileResponse> fromUploadedFiles(List<UploadedFile> uploadedFiles) {
        return uploadedFiles.stream().map(UploadedFileResponse::new).collect(Collectors.toList());
    }

}
