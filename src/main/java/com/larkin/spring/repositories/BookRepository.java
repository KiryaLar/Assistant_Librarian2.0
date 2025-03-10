package com.larkin.spring.repositories;

import com.larkin.spring.models.Book;
import com.larkin.spring.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByPerson(Person person);
    List<Book> findByTitleStartingWith(String title);
}
