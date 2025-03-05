package com.larkin.spring.controllers;

import com.larkin.spring.dao.BookDao;
import com.larkin.spring.dao.PersonDao;
import com.larkin.spring.models.Book;
import com.larkin.spring.models.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {
    //В Spring MVC принято использовать RESTful-подход:
//
//GET /books → Список всех книг (index())
//GET /books/{id} → Просмотр конкретной книги (show())
//GET /books/new → Форма для добавления книги (newBook())
//POST /books → Создание новой книги (create())
//GET /books/{id}/edit → Форма для редактирования книги (edit())
//PATCH /books/{id} → Обновление книги (update())
//DELETE /books/{id} → Удаление книги (delete())

    BookDao bookDao;
    PersonDao personDao;

    @Autowired
    public BookController(BookDao bookDao, PersonDao personDao) {
        this.bookDao = bookDao;
        this.personDao = personDao;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookDao.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       @ModelAttribute("person") Person person,
                       Model model) {
        Optional<Book> maybeBook = bookDao.show(id);
        Optional<Person> maybeBookOwner = bookDao.getBookOwner(id);

        if (maybeBookOwner.isPresent()) {
            model.addAttribute("owner", maybeBookOwner.get());
        } else {
            model.addAttribute("people", personDao.index());
        }

        if (maybeBook.isPresent()) {
            model.addAttribute("book", maybeBook.get());
            return "books/show";
        }
        return "redirect:/books";

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
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") int id) {
        Optional<Book> maybeBook = bookDao.show(id);
        if (maybeBook.isPresent()) {
            model.addAttribute("book", maybeBook.get());
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
        bookDao.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDao.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int id) {
        bookDao.release(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id,
                         @ModelAttribute("person") Person person) {
        bookDao.assign(id, person);
        return "redirect:/books/" + id;
    }

}
