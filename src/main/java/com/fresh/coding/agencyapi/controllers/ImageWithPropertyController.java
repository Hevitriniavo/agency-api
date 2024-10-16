package com.fresh.coding.agencyapi.controllers;

import com.fresh.coding.agencyapi.dtos.ImageWithPropertyDTO;
import com.fresh.coding.agencyapi.services.ImageWithPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties/with/images")
@RequiredArgsConstructor
@CrossOrigin
public class ImageWithPropertyController {
    private final ImageWithPropertyService imageWithPropertyService;

    @GetMapping("/{propertyId}")
    public ImageWithPropertyDTO getAllImageByPropertyId(@PathVariable Long propertyId) {
        return imageWithPropertyService.findAllImageByPropertyId(propertyId);
    }
}
