package com.brittodev.bookstoreapi.controller;


import com.brittodev.bookstoreapi.dto.requestDto.BookCreateRequest;
import com.brittodev.bookstoreapi.dto.requestDto.BookUpdateRequest;
import com.brittodev.bookstoreapi.dto.responseDto.BookResponse;
import com.brittodev.bookstoreapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookUpdateRequest request) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.updateBook(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAll() {
        bookService.deleteByAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<Page<BookResponse>> getAll(
            @RequestParam(required = false , defaultValue = "0")
            Integer page,
            @RequestParam(required = false , defaultValue = "5")
            Integer size
    ) {
        return ResponseEntity.ok(bookService.getAll(page,size));
    }

}
