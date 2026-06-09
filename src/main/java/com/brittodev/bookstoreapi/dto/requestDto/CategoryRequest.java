package com.brittodev.bookstoreapi.dto.requestDto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequest(
        @NotBlank
        String name,
        String description
) {
}
