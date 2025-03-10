package com.larkin.spring.dao;

import com.larkin.spring.models.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
    public void update(int id, @Valid Person person) {

    }

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PersonDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> index() {
//        return jdbcTemplate.query("SELECT id, name, birth_year, email, address FROM person",
//                (rs, rowNum) -> Person.builder()
//                        .id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .birthYear(rs.getInt("birth_year"))
//                        .address(rs.getString("address"))
//                        .build())
//                ;
//    }
//
//    public Optional<Person> show(String email) {
//        return jdbcTemplate.query("SELECT * FROM person WHERE email=?",
//                        ps -> ps.setString(1, email),
//                        (rs, rowNum) -> Person.builder()
//                                .id(rs.getInt("id"))
//                                .name(rs.getString("name"))
//                                .birthYear(rs.getInt("birth_year"))
//                                .address(rs.getString("address"))
//                                .build())
//                .stream()
//                .findAny();
//    }
//
//    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", ps -> ps.setInt(1, id), new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny().orElse(null);
//    }
//
//    public void save(Person person) {
//        jdbcTemplate.update("INSERT INTO person(name, birth_year, email, address) VALUES(?, ?, ?, ?)", person.getName(), person.getBirthYear(), person.getEmail(), person.getAddress());
//    }
//
//    public void update(int id, Person updatedPerson) {
//        jdbcTemplate.update("UPDATE person SET name=?, birth_year=?, email=?, address=? WHERE id=?", updatedPerson.getName(), updatedPerson.getBirthYear(), updatedPerson.getEmail(), updatedPerson.getAddress(), id);
//    }
//
//    public void delete(int id) {
//
//
//        jdbcTemplate.update("DELETE FROM person WHERE id=?", id);
//    }
//
//    public List<Book> getBooksByPersonId(int id) {
//        return jdbcTemplate.query("SELECT * FROM book WHERE person_id = ?",
//                ps -> ps.setInt(1, id),
//                new BeanPropertyRowMapper<>(Book.class));
//    }
}























