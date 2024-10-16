package com.fresh.coding.agencyapi.controllers.properties;

import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.services.properties.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
@CrossOrigin
public class PropertyController {
    private final PropertyService propertyService;

    @GetMapping
    public List<PropertyDTO> findAllProperties() {
        return propertyService.findAllProperties();
    }

    @GetMapping("/{id}")
    public PropertyDTO findPropertyById(@PathVariable Long id) {
        return propertyService.findPropertyById(id);
    }

}
