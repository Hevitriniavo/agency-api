package com.fresh.coding.agencyapi.services;


import com.fresh.coding.agencyapi.dtos.ImageWithPropertyDTO;

public interface ImageWithPropertyService {
    ImageWithPropertyDTO findAllImageByPropertyId(Long propertyId);
}
