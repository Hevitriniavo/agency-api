package com.fresh.coding.agencyapi.dtos.users;

import com.fresh.coding.agencyapi.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Role is required")
    private Role role;

    @Size(min = 10, message = "Phone number must be at least 10 digits")
    private String phone;

    private String address;
    private String city;

    @Size(min = 5, message = "Postal code must be at least 5 characters")
    private String postalCode;

    private LocalDateTime registrationDate;
}
