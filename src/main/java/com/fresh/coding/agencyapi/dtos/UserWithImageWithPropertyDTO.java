package com.fresh.coding.agencyapi.dtos;

import com.fresh.coding.agencyapi.enums.Role;
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
public class UserWithImageWithPropertyDTO {

    private Long id;

    private String name;

    private String email;

    private Role role;

    private String phone;

    private String address;
    private String city;

    private String postalCode;

    private LocalDateTime registrationDate;

    private List<ImageWithPropertyDTO> properties;
}
