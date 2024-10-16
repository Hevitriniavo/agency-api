package com.fresh.coding.agencyapi.services.searchs;

import com.fresh.coding.agencyapi.dtos.pagination.PageInfo;
import com.fresh.coding.agencyapi.dtos.pagination.Paginate;
import com.fresh.coding.agencyapi.dtos.properties.PropertyDTO;
import com.fresh.coding.agencyapi.dtos.seachs.PropertySearch;
import com.fresh.coding.agencyapi.dtos.seachs.UserSearch;
import com.fresh.coding.agencyapi.dtos.users.UserDTO;
import com.fresh.coding.agencyapi.repositories.RepositoryFactory;
import com.fresh.coding.agencyapi.services.specifications.PropertySpec;
import com.fresh.coding.agencyapi.services.specifications.UserSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchWithPaginationServiceImpl implements SearchWithPaginationService {
    private final RepositoryFactory repositoryFactory;

    @Override
    public Paginate<List<UserDTO>> paginateUsers(UserSearch userSearch, int page, int size) {
        var spec = UserSpec.filter(userSearch);
        var pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "registrationDate"));
        var userPage = repositoryFactory.getUserRepository().findAll(spec, pageRequest);

        var users = userPage.getContent().stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole(),
                        user.getPhone(),
                        user.getAddress(),
                        user.getCity(),
                        user.getPostalCode(),
                        user.getRegistrationDate()
                ))
                .collect(Collectors.toList());

        var pageInfo = new PageInfo(
                userPage.hasNext(),
                userPage.hasPrevious(),
                userPage.getTotalPages(),
                userPage.getNumber(),
                (int) userPage.getTotalElements()
        );
        return new Paginate<>(users, pageInfo);
    }

    @Override
    public Paginate<List<PropertyDTO>> paginateProperties(PropertySearch propertySearch, int page, int size) {
        var spec = PropertySpec.filter(propertySearch);
        var pageRequest = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.ASC, "price"));
        var propertyPage = repositoryFactory.getPropertyRepository().findAll(spec, pageRequest);

        var properties = propertyPage.getContent().stream()
                .map(property -> new PropertyDTO(
                        property.getId(),
                        property.getTitle(),
                        property.getDescription(),
                        property.getPrice(),
                        property.getArea(),
                        property.getType(),
                        property.getCity(),
                        property.getPostalCode(),
                        property.getAddress(),
                        property.getCreationDate(),
                        property.getAvailability()
                ))
                .collect(Collectors.toList());

        var pageInfo = new PageInfo(
                propertyPage.hasNext(),
                propertyPage.hasPrevious(),
                propertyPage.getTotalPages(),
                propertyPage.getNumber(),
                (int) propertyPage.getTotalElements()
        );

        return new Paginate<>(properties, pageInfo);
    }
}
