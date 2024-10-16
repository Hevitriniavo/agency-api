package com.fresh.coding.agencyapi.services.properties;

import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.exceptions.HttpNotFoundException;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public List<PropertyDTO> findAllProperties() {
        var propertyRepository = repositoryFactory.getPropertyRepository();
        return propertyRepository.findAll().stream()
                .map(property -> BeanUtils.map(property, PropertyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDTO findPropertyById(Long id) {
        var propertyRepository = repositoryFactory.getPropertyRepository();
        var property = propertyRepository.findById(id)
                .orElseThrow(() -> new HttpNotFoundException("Property not found with id: " + id));

        return BeanUtils.map(property, PropertyDTO.class);
    }
}
