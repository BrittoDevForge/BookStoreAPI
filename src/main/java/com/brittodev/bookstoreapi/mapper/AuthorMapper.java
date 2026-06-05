package com.brittodev.bookstoreapi.mapper;

import com.brittodev.bookstoreapi.dto.requestDto.AuthorRequest;
import com.brittodev.bookstoreapi.dto.responseDto.AuthorResponse;
import com.brittodev.bookstoreapi.entity.Author;

public class AuthorMapper {

    private AuthorMapper() {}

    public static Author toEntity(AuthorRequest request) {
        return Author.builder()
                .name(request.name())
                .bio(request.bio())
                .build();
    }

    public static AuthorResponse toResponse(Author author) {
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBio()
        );
    }

    public static void toUpdateEntity(AuthorRequest request, Author author) {
        if (request.bio() != null) {
            author.setBio(request.bio());
        }
        if (request.name() != null) {
            author.setName(request.name());
        }
    }
}
