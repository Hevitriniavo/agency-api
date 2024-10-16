package com.fresh.coding.agencyapi.services.users;

import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserServiceImpl implements DeleteUserService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public void deleteUser(Long id) {
        var userRepository = repositoryFactory.getUserRepository();
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User with id " + id + " does not exist");
        }
    }
}
