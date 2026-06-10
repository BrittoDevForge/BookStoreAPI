package com.brittodev.bookstoreapi.dto.responseDto;

public record UserResponse(
        Long id,
        String userName,
        String role
) {
}
