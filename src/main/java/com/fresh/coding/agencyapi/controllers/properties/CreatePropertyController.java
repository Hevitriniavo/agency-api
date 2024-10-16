package com.fresh.coding.agencyapi.controllers.properties;

import com.fresh.coding.agencyapi.dtos.properties.CreatePropertyDTO;
import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.services.properties.CreatePropertyService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
@CrossOrigin
public class CreatePropertyController {
    private final CreatePropertyService createPropertyService;

    @PostMapping
    public PropertyDTO createProperty (
            @RequestBody @Valid @NonNull CreatePropertyDTO toCreate
    ) {
        return createPropertyService.createProperty(toCreate);
    }
}
