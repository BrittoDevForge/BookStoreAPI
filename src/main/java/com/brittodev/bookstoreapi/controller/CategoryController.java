package com.brittodev.bookstoreapi.controller;


import com.brittodev.bookstoreapi.dto.requestDto.CategoryRequest;
import com.brittodev.bookstoreapi.dto.responseDto.CategoryResponse;
import com.brittodev.bookstoreapi.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody @Valid CategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.addCategory(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable Long id,
            @RequestBody @Valid CategoryRequest request
    ) {
        return ResponseEntity.ok(categoryService.updateCategory(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id
    ) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteAll() {
        categoryService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @GetMapping("/")
    public ResponseEntity<Page<CategoryResponse>> getAll(
            @RequestParam(required = false , defaultValue = "0")
            Integer page,
            @RequestParam(required = false , defaultValue = "5")
            Integer size
    ) {
        return ResponseEntity.ok(categoryService.getAll(page,size));
    }
}

