package com.fresh.coding.agencyapi.services.specifications;

import com.fresh.coding.agencyapi.dtos.seachs.UserSearch;
import com.fresh.coding.agencyapi.entities.User;
import com.fresh.coding.agencyapi.enums.Role;
import org.springframework.data.jpa.domain.Specification;


public class UserSpec {
    public static Specification<User> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name != null && !name.trim().isEmpty()) {
                return criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")),
                        "%" + name.trim().toLowerCase() + "%"
                );
            }
            return null;
        };
    }

    public static Specification<User> hasRole(Role role) {
        return (root, query, criteriaBuilder) -> {
            if (role != null) {
                return criteriaBuilder.equal(root.get("role"), role);
            }
            return null;
        };
    }

    public static Specification<User> hasPhone(String phone) {
        return (root, query, criteriaBuilder) -> {
            if (phone != null && !phone.trim().isEmpty()) {
                return criteriaBuilder.equal(root.get("phone"), phone);
            }
            return null;
        };
    }

    public static Specification<User> hasAddress(String address) {
        return (root, query, criteriaBuilder) -> {
            if (address != null && !address.trim().isEmpty()) {
                return criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("address")),
                        "%" + address.trim().toLowerCase() + "%"
                );
            }
            return null;
        };
    }

    public static Specification<User> hasCity(String city) {
        return (root, query, criteriaBuilder) -> {
            if (city != null && !city.trim().isEmpty()) {
                return criteriaBuilder.equal(
                        criteriaBuilder.lower(root.get("city")),
                        city.trim().toLowerCase()
                );
            }
            return null;
        };
    }

    public static Specification<User> hasPostalCode(String postalCode) {
        return (root, query, criteriaBuilder) -> {
            if (postalCode != null && !postalCode.trim().isEmpty()) {
                return criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("postalCode")),
                        "%" + postalCode.trim().toLowerCase() + "%"
                );
            }
            return null;
        };
    }


    public static Specification<User> filter(UserSearch search) {
        Specification<User> spec = Specification.where(null);

        if (search.getName() != null && !search.getName().trim().isEmpty()) {
            spec = spec.and(hasName(search.getName()));
        }

        if (search.getRole() != null) {
            spec = spec.and(hasRole(search.getRole()));
        }

        if (search.getPhone() != null && !search.getPhone().trim().isEmpty()) {
            spec = spec.and(hasPhone(search.getPhone()));
        }

        if (search.getAddress() != null && !search.getAddress().trim().isEmpty()) {
            spec = spec.and(hasAddress(search.getAddress()));
        }

        if (search.getCity() != null && !search.getCity().trim().isEmpty()) {
            spec = spec.and(hasCity(search.getCity()));
        }

        if (search.getPostalCode() != null && !search.getPostalCode().trim().isEmpty()) {
            spec = spec.and(hasPostalCode(search.getPostalCode()));
        }

        return spec;
    }
}
