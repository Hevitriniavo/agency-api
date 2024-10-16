package com.fresh.coding.agencyapi.services.users;

import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public UserDTO findUserById(Long id) {
        var user = repositoryFactory.getUserRepository().findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " does not exist"));
        return BeanUtils.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        var users = repositoryFactory.getUserRepository().findAll();
        return users.stream()
                .map(user -> BeanUtils.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}
