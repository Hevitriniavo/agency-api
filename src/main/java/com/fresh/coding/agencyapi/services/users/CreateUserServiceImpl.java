package com.fresh.coding.agencyapi.services.users;

import com.fresh.coding.agencyapi.dtos.users.CreateUserDTO;
import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import com.fresh.coding.agencyapi.entities.User;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public @NonNull UserDTO createUser(@NonNull CreateUserDTO createUserDTO) {
        var userRepo = repositoryFactory.getUserRepository();
        User user = BeanUtils.map(createUserDTO, User.class);
        User savedUser = userRepo.save(user);
        return BeanUtils.map(savedUser, UserDTO.class);
    }
}
