package com.pos.pos_backend.controller;

import com.pos.pos_backend.Dto.FileCopyRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Value("${file.upload-dir}") // Inject the upload directory path from application.properties
    private String uploadDir;

    // Upload an image
    @PostMapping("/copy")
    public ResponseEntity<String> copyImage(@RequestBody FileCopyRequest request) {
        try {
            // Define source and destination paths from request body
            Path sourcePath = Paths.get(request.getImagePathFromMachine());
            Path destinationPath = Paths.get(request.getCopyToFolderpath(), sourcePath.getFileName().toString());

            // Check if source file exists
            if (!Files.exists(sourcePath)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Source file does not exist: " + sourcePath);
            }

            // Create the destination directory if it doesn't exist
            Files.createDirectories(destinationPath.getParent());

            // Copy the file
            Files.copy(sourcePath, destinationPath);

            // Return success response
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
            // Resolve the file path
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();

            // Make sure the file exists
            File file = filePath.toFile();
            if (!file.exists() || !file.isFile()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            // Load the file as a resource
            Resource resource = new UrlResource(filePath.toUri());

            // Return the file as a resource with proper content headers for inline display
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
