package com.fresh.coding.agencyapi.controllers;

import com.fresh.coding.agencyapi.dtos.UserWithImageWithPropertyDTO;
import com.fresh.coding.agencyapi.services.UserWithImageWithPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/with/properties/with/images")
@RequiredArgsConstructor
@CrossOrigin
public class UserWithImageWithPropertyController {
    private final UserWithImageWithPropertyService userWithImageWithPropertyService;

    @GetMapping("/{userId}")
    public UserWithImageWithPropertyDTO getAllImageByPropertyId(@PathVariable Long userId) {
        return userWithImageWithPropertyService.findAllPropertiesByUserId(userId);
    }

}
