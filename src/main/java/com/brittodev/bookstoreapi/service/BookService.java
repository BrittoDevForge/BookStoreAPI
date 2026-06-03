package com.brittodev.bookstoreapi.service;


import com.brittodev.bookstoreapi.dto.requestDto.BookCreateRequest;
import com.brittodev.bookstoreapi.dto.responseDto.BookResponse;
import com.brittodev.bookstoreapi.entity.Book;
import com.brittodev.bookstoreapi.mapper.responseMaper.BookMapper;
import com.brittodev.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse addBook(BookCreateRequest request) {
        Book book = Book.builder()
                .isbn(request.isbn())
                .title(request.title())
                .description(request.description())
                .stockQuantity(request.stockQuantity())
                .price(request.price())
                .coverImageUrl(request.coverImageUrl())
                .build();
        return BookMapper.toResponse(bookRepository.save(book));
    }


}
