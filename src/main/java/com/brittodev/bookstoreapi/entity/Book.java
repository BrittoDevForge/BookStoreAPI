package com.brittodev.bookstoreapi.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_table")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    @Size(min = 10 , max = 17)
    @Pattern(regexp = "^[0-9-]+$", message = "ISBN must contain only digits and hyphens")
    String isbn;

    @NotBlank
    String title;
    String description;

    @PositiveOrZero
    Short stockQuantity;

    @PositiveOrZero
    Double price;

    @CreatedDate
    @Column(updatable = false)
    LocalDateTime createdAt;
    @LastModifiedDate
    LocalDateTime updatedAt;

    @Builder.Default
    Boolean isDeleted = false;

    @URL(message = "cover image must be an valid url")
    String coverImageUrl;

}
