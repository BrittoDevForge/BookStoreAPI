package com.brittodev.bookstoreapi.service;


import com.brittodev.bookstoreapi.dto.requestDto.BookCreateRequest;
import com.brittodev.bookstoreapi.dto.requestDto.BookUpdateRequest;
import com.brittodev.bookstoreapi.dto.responseDto.BookResponse;
import com.brittodev.bookstoreapi.entity.Book;
import com.brittodev.bookstoreapi.mapper.BookMapper;
import com.brittodev.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.*;


@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse addBook(BookCreateRequest request) {
        Book book = BookMapper.toEntity(request);
        return BookMapper.toResponse(bookRepository.save(book));
    }

    public BookResponse updateBook(Long id , BookUpdateRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("book not found")
        );
        BookMapper.toUpdateEntity(request,book);

        return BookMapper.toResponse(bookRepository.save(book));
    }

    public void deleteById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new RuntimeException("book not found for this id")
        );
        book.setIsDeleted(true);
        bookRepository.save(book);
    }

    public void deleteByAll() {
        bookRepository.findAll().forEach(
                book -> {
                    book.setIsDeleted(true);
                    bookRepository.save(book);
                }
        );
    }

    public BookResponse getById(Long id) {
        return BookMapper.toResponse(bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found")));
    }

    public Page<BookResponse> getAll(Integer page , Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return bookRepository.findAll(pageable).map(
                BookMapper::toResponse
        );
    }


}
