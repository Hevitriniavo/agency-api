package com.fresh.coding.agencyapi.services;

import com.fresh.coding.agencyapi.dtos.ImageWithPropertyDTO;
import com.fresh.coding.agencyapi.dtos.images.ImageDTO;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageWithPropertyServiceImpl implements ImageWithPropertyService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public ImageWithPropertyDTO findAllImageByPropertyId(Long propertyId) {
        var property = repositoryFactory.getPropertyRepository()
                .findPropertyWithImagesById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        var dto = BeanUtils.map(property, ImageWithPropertyDTO.class);
        var imageDTOs = property.getImages().stream()
                .map(image -> new ImageDTO(image.getId(), image.getThumbnail()))
                .collect(Collectors.toList());
        dto.setImages(imageDTOs);

        return dto;
    }
}
