package com.brittodev.bookstoreapi.mapper.responseMaper;

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
}
