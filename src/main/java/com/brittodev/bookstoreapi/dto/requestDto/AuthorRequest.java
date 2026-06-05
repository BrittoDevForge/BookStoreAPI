package com.brittodev.bookstoreapi.dto.requestDto;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequest(
        @NotBlank
        String name,
        String bio
) {
}
