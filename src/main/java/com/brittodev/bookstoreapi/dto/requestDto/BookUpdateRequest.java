package com.brittodev.bookstoreapi.dto.requestDto;

public record BookUpdateRequest(
        String isbn,
        String title,
        String description,
        Short stockQuantity,
        Double price,
        String coverImageUrl
) {
}
