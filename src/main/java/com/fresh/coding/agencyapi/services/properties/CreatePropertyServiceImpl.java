package com.fresh.coding.agencyapi.services.properties;

import com.fresh.coding.agencyapi.dtos.properties.CreatePropertyDTO;
import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.entities.Property;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreatePropertyServiceImpl implements CreatePropertyService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public @NonNull PropertyDTO createProperty(@NonNull CreatePropertyDTO toCreate) {
        Long userId = toCreate.getUserId();
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        var userOptional = repositoryFactory.getUserRepository().findById(userId);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + userId + " does not exist");
        }

        var property = BeanUtils.map(toCreate, Property.class);

        property.setUser(userOptional.get());

        property = repositoryFactory.getPropertyRepository().save(property);

        return BeanUtils.map(property, PropertyDTO.class);
    }
}
