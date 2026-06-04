package com.brittodev.bookstoreapi.dto.responseDto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timeStamp,
        Integer status,
        String error,
        String message,
        String path
) {
}
