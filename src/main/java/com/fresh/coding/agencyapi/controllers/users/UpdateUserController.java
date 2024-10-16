package com.fresh.coding.agencyapi.controllers.users;

import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import com.fresh.coding.agencyapi.services.users.UpdateUserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UpdateUserController {
    private final UpdateUserService updateUserService;

    @PutMapping("/{id}")
    public UserDTO updateUser(
            @PathVariable Long id,
            @RequestBody @Valid @NonNull UserDTO userDTO
    ) {
        userDTO.setId(id);
        return updateUserService.updateUser(userDTO);
    }
}
