package com.fresh.coding.agencyapi.services.properties;

import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import lombok.NonNull;

@FunctionalInterface
public interface UpdatePropertyService {
    @NonNull
    PropertyDTO updateProperty(@NonNull PropertyDTO toUpdate);
}
