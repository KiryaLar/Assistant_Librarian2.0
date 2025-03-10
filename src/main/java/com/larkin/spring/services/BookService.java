package com.larkin.spring.services;

import com.larkin.spring.models.Book;
import com.larkin.spring.models.Person;
import com.larkin.spring.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findBooksByPerson(Person person) {
        var booksByPerson = bookRepository.findByPerson(person);
        for (Book book : booksByPerson) {
            if (ChronoUnit.DAYS.between(book.getBorrowedAt(), LocalDateTime.now()) > 10) {
                book.setExpired(true);
            }
        }
        return booksByPerson;
    }

    public List<Book> findAll(boolean sortByYear) {
        if (sortByYear) {
            return bookRepository.findAll(Sort.by("year"));
        } else {
            return bookRepository.findAll();
        }
    }

    public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear) {
        if (sortByYear) {
            return bookRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
        } else {
            return bookRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
        }
    }

    public Book findById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleStartingWith(title);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book book) {
        Book updatedBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));

        updatedBook.setTitle(book.getTitle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setYear(book.getYear());
    }

    @Transactional
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void release(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        if (book.isExpired()) {
            book.setExpired(false);
        }
        book.setBorrowedAt(null);
        book.setPerson(null);
    }

    @Transactional
    public void assign(int id, Person person) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        book.setBorrowedAt(LocalDateTime.now());
        book.setPerson(person);
    }

    public int getTotalPages(int booksPerPage) {
        long totalBooks = bookRepository.count();
        return (int) Math.ceil((double) totalBooks / booksPerPage);
    }
}
