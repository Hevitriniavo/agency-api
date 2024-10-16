package com.fresh.coding.agencyapi.services.users;

import com.fresh.coding.agencyapi.dtos.users.CreateUserDTO;
import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import lombok.NonNull;

@FunctionalInterface
public interface CreateUserService {
    @NonNull
    UserDTO createUser(@NonNull CreateUserDTO createUserDTO);
}