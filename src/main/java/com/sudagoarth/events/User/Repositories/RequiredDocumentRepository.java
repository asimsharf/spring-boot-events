package com.sudagoarth.events.User.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudagoarth.events.UploadedFile.Entities.RequiredDocument;

public interface RequiredDocumentRepository extends JpaRepository<RequiredDocument, Long> {

}
