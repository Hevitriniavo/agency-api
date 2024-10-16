package com.fresh.coding.agencyapi.dtos.seachs;

import com.fresh.coding.agencyapi.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSearch {

    private String name;

    private Role role;

    private String phone;

    private String address;

    private String city;

    private String postalCode;

}
