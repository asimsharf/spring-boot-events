package com.sudagoarth.events.UploadedFile.DataTransferObjects;

import java.util.List;
import java.util.stream.Collectors;


import com.sudagoarth.events.UploadedFile.Entities.UploadedFile;

public class UploadedFileResponse {

    private Long id;

    private String fileName;

    private String fileType;

    private String filePath;

    private Long fileSize;

    private String fileDownloadUri;

    private String fileExtension;

    public UploadedFileResponse() {
    }

    public UploadedFileResponse(Long id, String fileName, String fileType, String filePath, Long fileSize,
            String fileDownloadUri, String fileExtension) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileDownloadUri = fileDownloadUri;
        this.fileExtension = fileExtension;
    }

    public UploadedFileResponse(String fileName, String fileType, String filePath, Long fileSize,
            String fileDownloadUri, String fileExtension) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.fileDownloadUri = fileDownloadUri;
        this.fileExtension = fileExtension;
    }

    public UploadedFileResponse(UploadedFile uploadedFile) {
        this.id = uploadedFile.getId();
        this.fileName = uploadedFile.getFileName();
        this.fileType = uploadedFile.getFileType();
        this.filePath = uploadedFile.getFilePath();
        this.fileSize = uploadedFile.getFileSize();
        this.fileDownloadUri = uploadedFile.getFileDownloadUri();
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

    public static List<UploadedFileResponse> fromUploadedFiles(List<UploadedFile> uploadedFiles) {
        return uploadedFiles.stream().map(UploadedFileResponse::new).collect(Collectors.toList());
    }
    


}
