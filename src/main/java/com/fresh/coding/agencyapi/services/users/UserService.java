package com.fresh.coding.agencyapi.services.users;

import com.fresh.coding.agencyapi.dtos.users.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO findUserById(Long id);

    List<UserDTO> findAllUsers();
}
