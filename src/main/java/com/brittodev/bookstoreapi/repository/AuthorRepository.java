package com.brittodev.bookstoreapi.repository;

import com.brittodev.bookstoreapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
