package com.fresh.coding.agencyapi.services;

import com.fresh.coding.agencyapi.dtos.UserWithImageWithPropertyDTO;

public interface UserWithImageWithPropertyService {
    UserWithImageWithPropertyDTO findAllPropertiesByUserId(Long userId);
}
