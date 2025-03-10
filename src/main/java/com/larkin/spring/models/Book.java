package com.larkin.spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString(exclude = "person")
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title should not be empty.")
    @Size(min = 2, max = 100, message = "The book title should be between 2 and 100 characters long.")
    private String title;

    @NotEmpty(message = "Author should not be empty.")
    @Pattern(regexp = "^([А-ЯЁA-Z]\\.([А-ЯЁA-Z]\\.)*\\s[А-ЯЁA-Zа-яёa-z]+)(,\\\\s?[А-ЯЁA-Z]\\\\.([А-ЯЁA-Z]\\\\.)*\\\\s[А-ЯЁA-Zа-яёa-z]+)*$",
            message = "Author should be in the format 'A.S. Pushkin' and separated by a comma if multiple.")
    private String author;

    @NotNull(message = "Year should not be empty.")
    @Min(value = 1, message = "The year of publication should be in our era")
    @Max(value = 2025, message = "The year of publication must be less than 2025")
    private Integer year;

    @Column(name = "borrowed_at")
    private LocalDateTime borrowedAt;

    @Transient
    private boolean isExpired;

    @ManyToOne
    private Person person;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
