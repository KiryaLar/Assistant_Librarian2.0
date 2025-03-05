package com.larkin.spring.dao;

import com.larkin.spring.models.Book;
import com.larkin.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT id, name, birth_year, email, address FROM person",
                (rs, rowNum) -> Person.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .birthYear(rs.getInt("birth_year"))
                        .address(rs.getString("address"))
                        .build())
                ;
    }

    public Optional<Person> show(String email) {
        return jdbcTemplate.query("SELECT * FROM person WHERE email=?",
                        ps -> ps.setString(1, email),
                        (rs, rowNum) -> Person.builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .birthYear(rs.getInt("birth_year"))
                                .address(rs.getString("address"))
                                .build())
                .stream()
                .findAny();
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", ps -> ps.setInt(1, id), new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(name, birth_year, email, address) VALUES(?, ?, ?, ?)", person.getName(), person.getBirthYear(), person.getEmail(), person.getAddress());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET name=?, birth_year=?, email=?, address=? WHERE id=?", updatedPerson.getName(), updatedPerson.getBirthYear(), updatedPerson.getEmail(), updatedPerson.getAddress(), id);
    }

    public void delete(int id) {


        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id = ?",
                ps -> ps.setInt(1, id),
                new BeanPropertyRowMapper<>(Book.class));
    }
}























