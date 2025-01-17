package com.fresh.coding.agencyapi.repositories;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RepositoryFactory {
    private final Map<String, JpaRepository<?, ?>> repositories;

    @SuppressWarnings("unchecked")
    private <T extends JpaRepository<?, ?>> T getRepositoryFor(String name) {
        JpaRepository<?, ?> repository = repositories.get(name);
        if (repository == null) {
            throw new IllegalArgumentException(String.format("Repository %s not defined", name));
        }
        return (T) repository;
    }


    public UserRepository getUserRepository() {
        return getRepositoryFor("userRepository");
    }

    public PropertyRepository getPropertyRepository() {
        return getRepositoryFor("propertyRepository");
    }

    public ImageRepository getImageRepository() {
        return getRepositoryFor("imageRepository");
    }

}
