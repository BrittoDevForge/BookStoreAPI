package com.brittodev.bookstoreapi.mapper;

import com.brittodev.bookstoreapi.dto.requestDto.CategoryRequest;
import com.brittodev.bookstoreapi.dto.responseDto.CategoryResponse;
import com.brittodev.bookstoreapi.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequest request) {
        return Category.builder()
                .name(request.name())
                .description(request.description())
                .build();
    }

    public static void updateEntityFromRequest(CategoryRequest request,Category category) {
        if (request.name() != null) {
            category.setName(request.name());
        }
        if (request.description() != null) {
            category.setDescription(request.description());
        }
    }

    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
    }
}
