package com.fresh.coding.agencyapi.controllers.users;

import com.fresh.coding.agencyapi.dtos.users.CreateUserDTO;
import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import com.fresh.coding.agencyapi.services.users.CreateUserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class CreateUserController {
    private final CreateUserService createUserService;

    @PostMapping
    public UserDTO createUser(
            @RequestBody @Valid @NonNull CreateUserDTO toCreate
    ) {
        return createUserService.createUser(toCreate);
    }
}
