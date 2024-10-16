package com.fresh.coding.agencyapi.services.properties;

import com.fresh.coding.agencyapi.dtos.properties.CreatePropertyDTO;
import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import lombok.NonNull;

@FunctionalInterface
public interface CreatePropertyService {
    @NonNull
    PropertyDTO createProperty(@NonNull CreatePropertyDTO toCreate);
}
