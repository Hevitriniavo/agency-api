package com.fresh.coding.agencyapi.repositories;

import com.fresh.coding.agencyapi.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
