package com.fresh.coding.agencyapi.dtos.properties;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePropertyDTO extends PropertyDTO {

    @NotNull(message = "User ID cannot be null")
    private Long userId;
}
