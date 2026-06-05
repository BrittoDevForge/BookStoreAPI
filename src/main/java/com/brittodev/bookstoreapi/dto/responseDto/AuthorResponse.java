package com.brittodev.bookstoreapi.dto.responseDto;

public record AuthorResponse(
        Long id,
        String name,
        String bio
) {
}
