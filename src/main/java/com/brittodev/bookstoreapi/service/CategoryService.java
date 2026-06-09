package com.brittodev.bookstoreapi.service;


import com.brittodev.bookstoreapi.dto.requestDto.CategoryRequest;
import com.brittodev.bookstoreapi.dto.responseDto.CategoryResponse;
import com.brittodev.bookstoreapi.entity.Category;
import com.brittodev.bookstoreapi.exception.ResourceNotFoundException;
import com.brittodev.bookstoreapi.mapper.CategoryMapper;
import com.brittodev.bookstoreapi.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse addCategory(CategoryRequest request) {
        return CategoryMapper.toResponse(categoryRepository.save(CategoryMapper.toEntity(request)));
    }

    public CategoryResponse updateCategory(Long id,CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No category found for this id : " + id));
        CategoryMapper.updateEntityFromRequest(request,category);
        return CategoryMapper.toResponse(categoryRepository.save(category));
    }

    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Category found for this id : " + id));
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }

    public void deleteAll() {
        categoryRepository.findAll().forEach(
                        category -> {
                            category.setIsDeleted(true);
                            categoryRepository.save(category);
                        }
                );
    }

    public CategoryResponse getById(Long id) {
        return CategoryMapper.toResponse(categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id : " + id)));
    }

    public Page<CategoryResponse> getAll(Integer page , Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return categoryRepository.findAll(pageable).map(
                CategoryMapper::toResponse
        );
    }
}
