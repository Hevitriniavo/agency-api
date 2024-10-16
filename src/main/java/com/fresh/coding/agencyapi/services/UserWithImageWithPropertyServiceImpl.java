package com.fresh.coding.agencyapi.services;

import com.fresh.coding.agencyapi.dtos.ImageWithPropertyDTO;
import com.fresh.coding.agencyapi.dtos.UserWithImageWithPropertyDTO;
import com.fresh.coding.agencyapi.dtos.images.ImageDTO;
import com.fresh.coding.agencyapi.entities.Property;
import com.fresh.coding.agencyapi.exceptions.HttpNotFoundException;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserWithImageWithPropertyServiceImpl implements UserWithImageWithPropertyService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public UserWithImageWithPropertyDTO findAllPropertiesByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("User ID must be a positive number.");
        }

        var properties = repositoryFactory.getPropertyRepository()
                .findPropertiesByUserId(userId);

        var propertyDTOs = properties.stream()
                .map(this::mapPropertyToDTO)
                .collect(Collectors.toList());

        var userDTO = new UserWithImageWithPropertyDTO();
        var user = repositoryFactory.getUserRepository()
                .findById(userId)
                .orElseThrow(() -> new HttpNotFoundException("User not found with ID: " + userId));

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        userDTO.setRegistrationDate(user.getRegistrationDate());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());
        userDTO.setCity(user.getCity());
        userDTO.setPostalCode(user.getPostalCode());
        userDTO.setProperties(propertyDTOs);

        return userDTO;
    }

    private ImageWithPropertyDTO mapPropertyToDTO(Property property) {
        var dto = BeanUtils.map(property, ImageWithPropertyDTO.class);
        dto.setImages(property.getImages().stream()
                .map(image -> new ImageDTO(image.getId(), image.getThumbnail()))
                .collect(Collectors.toList()));
        return dto;
    }
}
