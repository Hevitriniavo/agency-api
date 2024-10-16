package com.fresh.coding.agencyapi.services.users;

import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserServiceImpl implements UpdateUserService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public @NonNull UserDTO updateUser(@NonNull UserDTO userDTO) {
        var userRepo = repositoryFactory.getUserRepository();
        var existingUser = userRepo.findById(userDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userDTO.getId()));
        BeanUtils.map(userDTO, existingUser);
        var updatedUser = userRepo.save(existingUser);
        return BeanUtils.map(updatedUser, UserDTO.class);
    }
}
