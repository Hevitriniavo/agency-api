package com.fresh.coding.agencyapi.dtos.seachs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertySearch {

    private String title;

    private Double minPrice;

    private Double maxPrice;

    private Integer minArea;

    private Integer maxArea;

    private String type;

    private String city;

    private String address;

    private String postalCode;

    private Boolean availability;
}
