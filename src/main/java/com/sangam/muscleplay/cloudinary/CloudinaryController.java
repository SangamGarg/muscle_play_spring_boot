package com.sangam.muscleplay.cloudinary;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CloudinaryController {
    @Autowired
    private CloudinaryService cloudinaryService;

    @Operation(summary = "This is the Api for getting the images from Cloudinary with folder name")
    @GetMapping("/getImages")
    public ResponseEntity<?> getImages(@RequestParam String folderName) {
        try {
            List<String> response = cloudinaryService.getImagesFromFolder(folderName);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
