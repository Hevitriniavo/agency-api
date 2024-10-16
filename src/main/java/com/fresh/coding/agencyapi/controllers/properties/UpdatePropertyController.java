package com.fresh.coding.agencyapi.controllers.properties;

import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.services.properties.UpdatePropertyService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
@CrossOrigin
public class UpdatePropertyController {

    private final UpdatePropertyService updatePropertyService;

    @PutMapping("/{id}")
    public PropertyDTO updateProperty(
            @PathVariable Long id,
            @RequestBody @Valid @NonNull PropertyDTO toUpdate
    ) {
        toUpdate.setId(id);
        return updatePropertyService.updateProperty(toUpdate);
    }
}
