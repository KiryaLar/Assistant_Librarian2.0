package com.larkin.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDao {

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public BookDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Book> index() {
//        String sql = "SELECT id, title, author, year, person_id FROM book";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
//    }
//
//
//    public Optional<Book> show(int id) {
//        String sql = "SELECT id, title, author, year, person_id FROM book WHERE id = ?";
//        try {
//            Book book = jdbcTemplate.queryForObject(sql,
//                    new BeanPropertyRowMapper<>(Book.class),
//                    id);
//            return Optional.ofNullable(book);
//        } catch (EmptyResultDataAccessException e) {
//            return Optional.empty();
//        }
//
//    }
//
//    public void save(Book book) {
//        String sql = "INSERT INTO book(title, author, year) VALUES (?,?,?)";
//        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getYear());
//    }
//
//    public void update(int id, Book book) {
//        String sql = "UPDATE book SET title = ?, author = ?, year = ? WHERE id = ?";
//        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getYear(), id);
//    }
//
//    public void delete(int id) {
//        String sql = "DELETE FROM book WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    public Optional<Person> getBookOwner(int id) {
//        String sql = """
//                SELECT person.*
//                FROM book
//                    JOIN person ON book.person_id = person.id
//                WHERE book.id = ?;
//                """;
//        return jdbcTemplate.query(sql, ps -> ps.setInt(1, id), new BeanPropertyRowMapper<>(Person.class))
//                .stream()
//                .findAny();
//    }
//
//    public void release(int id) {
//        String sql = "UPDATE book SET person_id = NULL WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    public void assign(int id, Person person) {
//        String sql = "UPDATE book SET person_id = ? WHERE id = ?";
//        jdbcTemplate.update(sql, person.getId(), id);
//    }
}
