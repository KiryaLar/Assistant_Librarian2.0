package com.larkin.spring.controllers;

import com.larkin.spring.models.Book;
import com.larkin.spring.models.Person;
import com.larkin.spring.services.BookService;
import com.larkin.spring.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {
    private final PersonService personService;

    BookService bookService;

    @Autowired
    public BookController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "books_per_page", required = false) Integer booksPerPage,
                        @RequestParam(value = "sort_by_year", required = false) Boolean sortByYear) {

        if (page == null) page = 0;
        if (booksPerPage == null) booksPerPage = 10;

        model.addAttribute("books", bookService.findWithPagination(page, booksPerPage, Boolean.TRUE.equals(sortByYear)));

        model.addAttribute("currentPage", page);
        model.addAttribute("currentBooksPerPage", booksPerPage);
        model.addAttribute("currentSortByYear", sortByYear);
        model.addAttribute("totalPages", bookService.getTotalPages(booksPerPage));

        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       @ModelAttribute("person") Person person,
                       Model model) {
        Book book = bookService.findById(id);
        Person maybeBookOwner = book.getPerson();

        if (maybeBookOwner != null) {
            model.addAttribute("owner", maybeBookOwner);
        } else {
            model.addAttribute("people", personService.findAll());
        }

        model.addAttribute("book", book);
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") int id) {
        Book book = bookService.findById(id);
        if (book != null) {
            model.addAttribute("book", book);
            return "books/edit";
        } else {
            return "redirect:/books";
        }
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        bookService.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int id) {
        bookService.release(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id,
                         @ModelAttribute("person") Person person) {
        bookService.assign(id, person);
        return "redirect:/books/" + id;
    }

    @GetMapping("/search")
    public String search() {
        return "books/search";
    }

    @PostMapping("/search")
    public String makeSearch(Model model,
                             @RequestParam("query") String query) {
        model.addAttribute("books", bookService.searchByTitle(query));
        return "books/search";
    }
}
