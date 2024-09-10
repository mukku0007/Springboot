package com.file_storage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file_storage.model.FileItem;

@Repository
public interface FileRepository extends JpaRepository<FileItem, Integer> {

	Optional<FileItem> findByFileName(String fileName);

}
