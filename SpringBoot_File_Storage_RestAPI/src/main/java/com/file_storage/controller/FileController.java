package com.file_storage.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file_storage.model.FileItem;
import com.file_storage.repository.FileRepository;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileRepository fileRepository;
	
	private final String FOLDER_PATH = "D:/uploads/";
	
	@PostMapping("/upload")
	public ResponseEntity<Object> uploadFIle(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		
		String path = FOLDER_PATH + file.getOriginalFilename();
		
		FileItem fileItem = FileItem.builder()
				.fileName(file.getOriginalFilename())
				.fileType(file.getContentType())
				.fileLocation(path)
				.build();
		
		fileRepository.save(fileItem);
		
		file.transferTo(new File(path).toPath());
		return ResponseEntity.status(HttpStatus.OK).body("File Uploaded Successfully to " + path);
	}
	
	
	@GetMapping("/download/{filename}")
	public ResponseEntity<Object> downloadFile(@PathVariable("filename") String fileName) throws IOException {
		Optional<FileItem> fileOptional = fileRepository.findByFileName(fileName);
		if(fileOptional.isPresent()) {
			FileItem fileItem = fileOptional.get();
			String path = fileItem.getFileLocation();
			byte[] fileByte = Files.readAllBytes(Path.of(path));
			return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.valueOf("image/png")).body(fileByte);
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found for FileName: "+fileName);
		}
	}
}
