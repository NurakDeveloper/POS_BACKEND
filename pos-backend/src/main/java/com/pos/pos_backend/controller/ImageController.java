package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.FileCopyRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Value("${file.upload-dir}") // Inject upload directory from application.properties
    private String uploadDir;

    // Upload an image
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Check if file is empty
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File is empty");
            }

            // Ensure the upload directory exists
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file
            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);

            // Check if file already exists
            if (Files.exists(filePath)) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("File already exists: " + filePath);
            }

            Files.write(filePath, file.getBytes());
            return ResponseEntity.ok("File uploaded successfully: " + filePath.toString());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading file: " + e.getMessage());
        }
    }

    // Copy an image from one directory to another
    @PostMapping("/copy")
    public ResponseEntity<String> copyImage(@RequestBody FileCopyRequest request) {
        try {
            Path sourcePath = Paths.get(request.getImagePathFromMachine());
            Path destinationPath = Paths.get(request.getCopyToFolderpath(), sourcePath.getFileName().toString());

            // Check if source file exists
            if (!Files.exists(sourcePath)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Source file does not exist: " + sourcePath);
            }

            // Ensure destination directory exists
            Files.createDirectories(destinationPath.getParent());

            // Copy the file
            Files.copy(sourcePath, destinationPath);
            return ResponseEntity.ok("File copied successfully to: " + destinationPath);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error copying file: " + e.getMessage());
        }
    }

    // Fetch an image by filename
    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();

            // Check if file exists
            if (!Files.exists(filePath)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            }

            // Load the file as a resource
            Resource resource = new UrlResource(filePath.toUri());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
