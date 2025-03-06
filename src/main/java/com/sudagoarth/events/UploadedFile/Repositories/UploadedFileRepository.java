package com.sudagoarth.events.UploadedFile.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudagoarth.events.UploadedFile.Entities.RequiredDocument;
import com.sudagoarth.events.UploadedFile.Entities.UploadedFile;

public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END FROM UploadedFile u WHERE u.requiredDocument = :requiredDocument")
    boolean existsByRequiredDocument(RequiredDocument requiredDocument);

    @Query("SELECT u FROM UploadedFile u WHERE u.requiredDocument = :requiredDocument")
    UploadedFile findByRequiredDocument(RequiredDocument requiredDocument);
}
