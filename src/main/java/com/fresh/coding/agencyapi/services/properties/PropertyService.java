package com.fresh.coding.agencyapi.services.properties;

import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;

import java.util.List;

public interface PropertyService {

    List<PropertyDTO> findAllProperties();

    PropertyDTO findPropertyById(Long id);
}
