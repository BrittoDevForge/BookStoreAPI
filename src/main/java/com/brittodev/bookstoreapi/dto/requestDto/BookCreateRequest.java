package com.brittodev.bookstoreapi.dto.requestDto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

public record BookCreateRequest(
        String isbn,
        @NotBlank
        String title,
        String description,
        @Positive
        @Min(value = 1,message = "minimum one stock is required")
        Short stockQuantity,
        @PositiveOrZero
        Double price,
        @URL(message = "cover image must be an valid URL")
        String coverImageUrl
) {

}