package com.brittodev.bookstoreapi.mapper;

import com.brittodev.bookstoreapi.dto.requestDto.BookCreateRequest;
import com.brittodev.bookstoreapi.dto.requestDto.BookUpdateRequest;
import com.brittodev.bookstoreapi.dto.responseDto.BookResponse;
import com.brittodev.bookstoreapi.entity.Book;

public class BookMapper {
    public static BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getStockQuantity(),
                book.getPrice(),
                book.getCreatedAt(),
                book.getUpdatedAt(),
                book.getCoverImageUrl()
        );
    }

    public static Book toEntity(BookCreateRequest request) {
        return Book.builder()
                .isbn(request.isbn())
                .title(request.title())
                .description(request.description())
                .stockQuantity(request.stockQuantity())
                .price(request.price())
                .coverImageUrl(request.coverImageUrl())
                .build();
    }

    public static void toUpdateEntity(BookUpdateRequest request, Book book) {
        if(request.isbn() != null) {
            book.setIsbn(request.isbn());
        }
        if(request.title() != null) {
            book.setTitle(request.title());
        }
        if(request.description() != null) {
            book.setDescription(request.description());
        }
        if(request.stockQuantity() != null) {
            book.setStockQuantity(request.stockQuantity());
        }
        if(request.price() != null) {
            book.setPrice(request.price());
        }
        if(request.coverImageUrl() != null) {
            book.setCoverImageUrl(request.coverImageUrl());
        }
    }
}
