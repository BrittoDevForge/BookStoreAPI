package com.brittodev.bookstoreapi.dto.requestDto;

import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.URL;

public record BookUpdateRequest(
        String isbn,
        String title,
        String description,
        @PositiveOrZero
        Short stockQuantity,
        @PositiveOrZero
        Double price,
        @URL(message = "must have valid url")
        String coverImageUrl
) {
}
