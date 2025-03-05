package com.larkin.spring.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private int id;

    @NotEmpty(message = "The full name should not be empty")
    @Pattern(
            regexp = "^[А-ЯЁA-Z][а-яёa-z]+\\s[А-ЯЁA-Z][а-яёa-z]+(\\s[А-ЯЁA-Z][а-яёa-z]+)?$",
            message = "The full name must contain at least the last name and the first name, starting with capital letters."
    )
    private String name;

    @Min(value = 1925, message = "The year of birth must be greater than 1925")
    @Max(value = 2025, message = "The year of birth must be less than 2025")
    @NotNull(message = "Year of birth should not be empty")
    private Integer birthYear;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: Country, City, Postal Code (6 digits)")
    @NotEmpty
    private String address;

}
