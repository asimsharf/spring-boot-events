package com.sudagoarth.events.UploadedFile.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sudagoarth.events.UploadedFile.Entities.RequiredDocument;

public interface RequiredDocumentRepository extends JpaRepository<RequiredDocument, Long> {

    @Query("SELECT r FROM RequiredDocument r WHERE r.entityType.id = ?1")
    List<RequiredDocument> findByEntityType(Long entityTypeId);

}
