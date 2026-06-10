package com.brittodev.bookstoreapi.dto.requestDto;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(

        @NotBlank
        String userName,

        String password,
        String role
) {
}
