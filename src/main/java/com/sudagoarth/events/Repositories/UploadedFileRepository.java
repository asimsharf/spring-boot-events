package com.sudagoarth.events.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudagoarth.events.Models.UploadedFile;

public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
}
