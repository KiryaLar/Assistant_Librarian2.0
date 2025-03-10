package com.larkin.spring.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString(exclude = "books")
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The full name should not be empty")
    @Pattern(
            regexp = "^[А-ЯЁA-Z][а-яёa-z]+\\s[А-ЯЁA-Z][а-яёa-z]+(\\s[А-ЯЁA-Z][а-яёa-z]+)?$",
            message = "The full name must contain at least the last name and the first name, starting with capital letters."
    )
    private String name;

    @Min(value = 1925, message = "The year of birth must be greater than 1925")
    @Max(value = 2025, message = "The year of birth must be less than 2025")
    @NotNull(message = "Year of birth should not be empty")
    @Column(name = "birth_year")
    private Integer birthYear;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^[A-Z][a-z]+(?:[\\s-][A-Z][a-z]+)*,\\s?\\d{6}$", message = "Your address should be in this format: City, Postal Code (6 digits)")
    @NotEmpty(message = "Address should not be empty")
    private String address;

    @OneToMany(mappedBy = "person")
    private List<Book> books;

    public Person(String name, Integer birthYear, String email, String address) {
        this.name = name;
        this.birthYear = birthYear;
        this.email = email;
        this.address = address;
    }
}
