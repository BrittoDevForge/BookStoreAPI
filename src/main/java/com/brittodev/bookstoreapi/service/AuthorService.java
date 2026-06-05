package com.brittodev.bookstoreapi.service;


import com.brittodev.bookstoreapi.dto.requestDto.AuthorRequest;
import com.brittodev.bookstoreapi.dto.responseDto.AuthorResponse;
import com.brittodev.bookstoreapi.entity.Author;
import com.brittodev.bookstoreapi.exception.ResourceNotFoundException;
import com.brittodev.bookstoreapi.mapper.AuthorMapper;
import com.brittodev.bookstoreapi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorResponse addAuthor(AuthorRequest request) {
        return AuthorMapper.toResponse(authorRepository.save(AuthorMapper.toEntity(request)));
    }

    public AuthorResponse updateAuthor(Long id,AuthorRequest request) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id : " + id));
        AuthorMapper.toUpdateEntity(request,author);
        return AuthorMapper.toResponse(authorRepository.save(author));
    }

    public void deleteById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id : " + id));
        author.setIsDeleted(true);
        authorRepository.save(author);
    }

    public void deleteAll() {
        authorRepository.findAll().forEach(
                author -> {
                    author.setIsDeleted(true);
                    authorRepository.save(author);
                }
        );
    }

    public AuthorResponse getById(Long id) {
        return AuthorMapper.toResponse(authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found for this id : " + id)));
    }

    public Page<AuthorResponse> getAll(Integer page , Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return authorRepository.findAll(pageable).map(
                AuthorMapper::toResponse
        );
    }
}
