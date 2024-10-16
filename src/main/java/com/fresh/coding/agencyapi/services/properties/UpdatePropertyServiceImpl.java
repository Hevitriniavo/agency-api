package com.fresh.coding.agencyapi.services.properties;

import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.exceptions.HttpNotFoundException;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePropertyServiceImpl implements UpdatePropertyService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public @NonNull PropertyDTO updateProperty(@NonNull PropertyDTO toUpdate) {
        var propertyRepository = repositoryFactory.getPropertyRepository();
        var property = propertyRepository.findById(toUpdate.getId())
                .orElseThrow(() -> new HttpNotFoundException("Property not found with id: " + toUpdate.getId()));
        BeanUtils.map(toUpdate, property);
        propertyRepository.save(property);
        return BeanUtils.map(property, PropertyDTO.class);
    }
}
