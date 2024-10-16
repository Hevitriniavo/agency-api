package com.fresh.coding.agencyapi.controllers.users;

import com.fresh.coding.agencyapi.services.users.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class DeleteUserController {
    private final DeleteUserService deleteUserService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        deleteUserService.deleteUser(id);
    }
}
