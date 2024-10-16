package com.fresh.coding.agencyapi.exceptions;

import java.time.LocalDate;

public record AppError<T>(
        T message,
        LocalDate date,
        int status
) {
}
