package com.fresh.coding.agencyapi.controllers.properties;

import com.fresh.coding.agencyapi.services.properties.DeletePropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/properties")
@RequiredArgsConstructor
@CrossOrigin
public class DeletePropertyController {

    private final DeletePropertyService deletePropertyService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProperty(@PathVariable Long id) {
        deletePropertyService.deleteProperty(id);
    }
}
