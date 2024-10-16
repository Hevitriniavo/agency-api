package com.fresh.coding.agencyapi.controllers.images;

import com.fresh.coding.agencyapi.dtos.images.ImageDTO;
import com.fresh.coding.agencyapi.services.images.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/properties/images")
@RequiredArgsConstructor
@CrossOrigin
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ImageDTO uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("propertyId") Long propertyId
    ) {
        return imageService.uploadImage(file, propertyId);
    }

    @PostMapping("/{id}")
    public ImageDTO updateImage(
            @PathVariable Long id,
            @RequestParam MultipartFile file,
            @RequestParam Long propertyId
    ) {
        return imageService.updateImage(id, file, propertyId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}
