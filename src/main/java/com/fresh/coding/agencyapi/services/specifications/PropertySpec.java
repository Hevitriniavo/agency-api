package com.fresh.coding.agencyapi.services.specifications;

import com.fresh.coding.agencyapi.dtos.seachs.PropertySearch;
import com.fresh.coding.agencyapi.entities.Property;
import org.springframework.data.jpa.domain.Specification;

public class PropertySpec {

    public static Specification<Property> hasTitle(String title) {
        return (root, query, criteriaBuilder) -> {
            if (title != null && !title.trim().isEmpty()) {
                return criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("title")),
                        "%" + title.trim().toLowerCase() + "%"
                );
            }
            return null;
        };
    }

    public static Specification<Property> hasMinPrice(Double minPrice) {
        return (root, query, criteriaBuilder) -> {
            if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
            return null;
        };
    }

    public static Specification<Property> hasMaxPrice(Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
            return null;
        };
    }

    public static Specification<Property> hasMinArea(Integer minArea) {
        return (root, query, criteriaBuilder) -> {
            if (minArea != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("area"), minArea);
            }
            return null;
        };
    }

    public static Specification<Property> hasMaxArea(Integer maxArea) {
        return (root, query, criteriaBuilder) -> {
            if (maxArea != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("area"), maxArea);
            }
            return null;
        };
    }

    public static Specification<Property> hasType(String type) {
        return (root, query, criteriaBuilder) -> {
            if (type != null && !type.trim().isEmpty()) {
                return criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("type")),
                        type.trim().toLowerCase()
                );
            }
            return null;
        };
    }

    public static Specification<Property> hasCity(String city) {
        return (root, query, criteriaBuilder) -> {
            if (city != null && !city.trim().isEmpty()) {
                return criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("city")),
                        city.trim().toLowerCase()
                );
            }
            return null;
        };
    }


    public static Specification<Property> hasPostalCode(String postalCode) {
        return (root, query, criteriaBuilder) -> {
            if (postalCode != null && !postalCode.trim().isEmpty()) {
                return criteriaBuilder.equal(root.get("postalCode"), postalCode);
            }
            return null;
        };
    }

    public static Specification<Property> hasAvailability(Boolean availability) {
        return (root, query, criteriaBuilder) -> {
            if (availability != null) {
                return criteriaBuilder.equal(root.get("availability"), availability);
            }
            return null;
        };
    }

    public static Specification<Property> hasAddress(String address) {
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


    public static Specification<Property> filter(PropertySearch search) {
        Specification<Property> spec = Specification.where(null);

        if (search.getTitle() != null && !search.getTitle().trim().isEmpty()) {
            spec = spec.and(hasTitle(search.getTitle()));
        }

        if (search.getMinPrice() != null) {
            spec = spec.and(hasMinPrice(search.getMinPrice()));
        }

        if (search.getMaxPrice() != null) {
            spec = spec.and(hasMaxPrice(search.getMaxPrice()));
        }

        if (search.getMinArea() != null) {
            spec = spec.and(hasMinArea(search.getMinArea()));
        }

        if (search.getMaxArea() != null) {
            spec = spec.and(hasMaxArea(search.getMaxArea()));
        }

        if (search.getType() != null && !search.getType().trim().isEmpty()) {
            spec = spec.and(hasType(search.getType()));
        }

        if (search.getCity() != null && !search.getCity().trim().isEmpty()) {
            spec = spec.and(hasCity(search.getCity()));
        }

        if (search.getAddress() != null && !search.getAddress().trim().isEmpty()) {
            spec = spec.and(hasAddress(search.getAddress()));
        }

        if (search.getPostalCode() != null && !search.getPostalCode().trim().isEmpty()) {
            spec = spec.and(hasPostalCode(search.getPostalCode()));
        }

        if (search.getAvailability() != null) {
            spec = spec.and(hasAvailability(search.getAvailability()));
        }

        return spec;
    }
}
