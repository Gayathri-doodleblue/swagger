package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.FileUpload;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
	Optional<FileUpload> findByName(String fileName);
}
