package com.brittodev.bookstoreapi.controller;


import com.brittodev.bookstoreapi.dto.requestDto.BookCreateRequest;
import com.brittodev.bookstoreapi.dto.responseDto.BookResponse;
import com.brittodev.bookstoreapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/books")
public class BookController {

    BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/")
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookCreateRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.addBook(request));
    }
}
