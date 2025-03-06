package com.sudagoarth.events.UploadedFile.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudagoarth.events.UploadedFile.Entities.UploadedFile;

public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
}
