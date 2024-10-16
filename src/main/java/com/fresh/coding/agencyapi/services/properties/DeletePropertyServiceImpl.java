package com.fresh.coding.agencyapi.services.properties;

import com.fresh.coding.agencyapi.exceptions.HttpNotFoundException;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePropertyServiceImpl implements DeletePropertyService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public void deleteProperty(Long id) {
        var propertyRepository = repositoryFactory.getPropertyRepository();
        if (!propertyRepository.existsById(id)) {
            throw new HttpNotFoundException("Property not found with ID: " + id);
        }
        propertyRepository.deleteById(id);
    }
}
