package com.larkin.spring.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

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

    private Integer personId;
}
