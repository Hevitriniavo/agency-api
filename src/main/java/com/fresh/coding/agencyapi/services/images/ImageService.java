package com.fresh.coding.agencyapi.services.images;

import com.fresh.coding.agencyapi.dtos.images.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ImageDTO updateImage(Long id, MultipartFile file, Long propertyId);

    ImageDTO uploadImage(MultipartFile file, Long propertyId);

    void deleteImage(Long id);
}
