package com.fresh.coding.agencyapi.services.users;

import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import lombok.NonNull;

@FunctionalInterface
public interface UpdateUserService {
    @NonNull
    UserDTO updateUser(@NonNull UserDTO userDTO);
}