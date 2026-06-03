package com.brittodev.bookstoreapi.dto.responseDto;

import java.time.LocalDateTime;

public record BookResponse(
        Long id,
        String isbn,
        String title,
        String description,
        Short stockQuantity,
        Double price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String coverImageUrl
) {
}
