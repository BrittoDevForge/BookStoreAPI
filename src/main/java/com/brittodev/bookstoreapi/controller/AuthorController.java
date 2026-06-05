package com.brittodev.bookstoreapi.controller;


import com.brittodev.bookstoreapi.dto.requestDto.AuthorRequest;
import com.brittodev.bookstoreapi.dto.responseDto.AuthorResponse;
import com.brittodev.bookstoreapi.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    AuthorService authorService;

    @Autowired
    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/")
    public ResponseEntity<AuthorResponse> addAuthor(@Valid @RequestBody AuthorRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authorService.addAuthor(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(
            @PathVariable Long id,
            @Valid @RequestBody AuthorRequest request
    ) {
        return ResponseEntity.ok(authorService.updateAuthor(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(
            @PathVariable @NotNull @Positive
            Long id
    ) {
        authorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAllAuthor() {
        authorService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthor(
            @PathVariable @NotNull @Positive
            Long id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authorService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<Page<AuthorResponse>> getAllAuthor(
            @RequestParam(required = false , defaultValue = "0")
            Integer page,
            @RequestParam(required = false , defaultValue = "5")
            Integer size
    ) {
        return ResponseEntity.ok(authorService.getAll(page,size));
    }

}
