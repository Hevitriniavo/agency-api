package com.fresh.coding.agencyapi.dtos;

import com.fresh.coding.agencyapi.dtos.images.ImageDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageWithPropertyDTO {
    private Long id;

    private String title;

    private String description;

    private Double price;

    private Integer area;

    private String type;

    private String address;

    private String city;

    private String postalCode;

    private LocalDateTime creationDate;
    private Boolean availability;

    private List<ImageDTO> images;
}
