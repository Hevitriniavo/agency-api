package com.fresh.coding.agencyapi.repositories;

import com.fresh.coding.agencyapi.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {
    @Query("SELECT p FROM Property p LEFT JOIN FETCH p.images WHERE p.id = :propertyId")
    Optional<Property> findPropertyWithImagesById(@Param("propertyId") Long propertyId);

    @Query("SELECT p FROM Property p LEFT JOIN FETCH p.images WHERE p.user.id = :userId")
    List<Property> findPropertiesByUserId(@Param("userId") Long userId);

}
