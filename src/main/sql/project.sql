create table person
(
    id      serial primary key,
    name    varchar(64) not null,
    birth_year     int check ( age > 0 ),
    email   varchar unique,
    address varchar(128)
);
INSERT INTO person (name, birth_year, email, address)
VALUES
    ('Stepan', 2005, 'stepan47@yandex.ru', 'Krasnoyarsk, 660000'),
    ('Nikita', 2000, 'nikita29@outlook.com', 'Samara, 443000'),
    ('Vasiliy', 2002, 'vasiliy52@mail.ru', 'Voronezh, 394000'),
    ('Oleg', 1990, 'oleg78@mail.ru', 'Krasnoyarsk, 660000'),
    ('Egor', 1996, 'egor10@outlook.com', 'Samara, 443000'),
    ('Vladimir', 2001, 'vladimir15@mail.ru', 'Novosibirsk, 630000'),
    ('Vasiliy', 1999, 'vasiliy2@yandex.ru', 'Ufa, 450000'),
    ('Timofey', 1988, 'timofey59@mail.ru', 'Perm, 614000'),
    ('Stanislav', 1998, 'stanislav50@yandex.ru', 'Nizhny Novgorod, 603000'),
    ('Denis', 1993, 'denis73@gmail.com', 'Saint Petersburg, 190000'),
    ('Egor', 1989, 'egor74@gmail.com', 'Volgograd, 400000'),
    ('Anatoly', 1998, 'anatoly2@mail.ru', 'Krasnoyarsk, 660000'),
    ('Yaroslav', 1988, 'yaroslav49@yandex.ru', 'Perm, 614000'),
    ('Evgeny', 2000, 'evgeny73@yandex.ru', 'Chelyabinsk, 454000'),
    ('Andrey', 2003, 'andrey75@yandex.ru', 'Omsk, 644000'),
    ('Maxim', 2001, 'maxim23@yandex.ru', 'Chelyabinsk, 454000'),
    ('Victor', 1989, 'victor25@mail.ru', 'Saint Petersburg, 190000'),
    ('Stepan', 1998, 'stepan19@outlook.com', 'Moscow, 119420'),
    ('Konstantin', 1985, 'konstantin3@outlook.com', 'Omsk, 644000'),
    ('Pavel', 1998, 'pavel2@yandex.ru', 'Omsk, 644000'),
    ('Nikita', 1999, 'nikita60@gmail.com', 'Novosibirsk, 630000'),
    ('Nikita', 2000, 'nikita75@gmail.com', 'Chelyabinsk, 454000'),
    ('Victor', 1990, 'victor4@yandex.ru', 'Moscow, 119420'),
    ('Maxim', 2004, 'maxim12@gmail.com', 'Nizhny Novgorod, 603000'),
    ('Dmitry', 1995, 'dmitry46@mail.ru', 'Perm, 614000'),
    ('Denis', 1996, 'denis55@mail.ru', 'Yekaterinburg, 620000'),
    ('Stepan', 1988, 'stepan35@gmail.com', 'Voronezh, 394000'),
    ('Timofey', 1992, 'timofey90@mail.ru', 'Nizhny Novgorod, 603000'),
    ('Stepan', 1988, 'stepan15@yandex.ru', 'Perm, 614000'),
    ('Vasiliy', 2004, 'vasiliy72@gmail.com', 'Chelyabinsk, 454000'),
    ('Anton', 2003, 'anton96@yandex.ru', 'Novosibirsk, 630000'),
    ('Stanislav', 2001, 'stanislav44@yandex.ru', 'Perm, 614000'),
    ('Timofey', 2005, 'timofey67@outlook.com', 'Moscow, 119420'),
    ('Egor', 1996, 'egor89@outlook.com', 'Moscow, 119420'),
    ('Yaroslav', 1992, 'yaroslav91@yandex.ru', 'Chelyabinsk, 454000'),
    ('Ilya', 1989, 'ilya61@yandex.ru', 'Moscow, 119420'),
    ('Stepan', 1993, 'stepan3@mail.ru', 'Omsk, 644000'),
    ('Gleb', 2004, 'gleb65@gmail.com', 'Perm, 614000'),
    ('Vasiliy', 1999, 'vasiliy40@outlook.com', 'Moscow, 119420'),
    ('Egor', 1998, 'egor26@yandex.ru', 'Perm, 614000'),
    ('Evgeny', 1995, 'evgeny98@outlook.com', 'Yekaterinburg, 620000'),
    ('Pavel', 1998, 'pavel73@outlook.com', 'Yekaterinburg, 620000'),
    ('Dmitry', 1999, 'dmitry44@gmail.com', 'Krasnoyarsk, 660000'),
    ('Mikhail', 1994, 'mikhail13@mail.ru', 'Saint Petersburg, 190000'),
    ('Stepan', 2001, 'stepan4@mail.ru', 'Voronezh, 394000'),
    ('Yaroslav', 1988, 'yaroslav93@yandex.ru', 'Samara, 443000'),
    ('Gleb', 1995, 'gleb21@mail.ru', 'Volgograd, 400000'),
    ('Roman', 1996, 'roman42@mail.ru', 'Volgograd, 400000'),
    ('Victor', 2000, 'victor15@mail.ru', 'Rostov-on-Don, 344000'),
    ('Vladimir', 1992, 'vladimir50@gmail.com', 'Ufa, 450000');



INSERT INTO book (title, author, year, person_id, borrowed_at)
values ('The Master and Margarita', 'M.A. Bulgakov', 1928, 12, '2025-02-08 10:12:33'),
       ('Crime and Punishment', 'F. Dostoevsky', 1866, 27, '2025-01-23 15:45:10'),
       ('War and Peace', 'L. Tolstoy', 1869, 34, '2025-02-15 09:37:21'),
       ('The Brothers Karamazov', 'F. Dostoevsky', 1880, 8, '2025-01-30 20:50:49'),
       ('Dead Souls', 'N. Gogol', 1842, 41, '2025-03-06 02:06:50'),
       ('Fathers and Sons', 'I. Turgenev', 1862, 31, '2025-02-23 16:06:43'),
       ('The Idiot', 'F. Dostoevsky', 1869, 50, '2025-01-25 14:59:41'),
       ('Doctor Zhivago', 'B. Pasternak', 1957, 19, '2025-01-15 11:44:11'),
       ('We', 'Y. Zamyatin', 1924, 20, '2025-02-13 17:00:38'),
       ('The Gulag Archipelago', 'A. Solzhenitsyn', 1973, 41, '2025-02-17 17:29:35'),
       ('And Quiet Flows the Don', 'M. Sholokhov', 1925, 7, '2025-02-03 22:00:01'),
       ('One Day in the Life of Ivan Denisovich', 'A. Solzhenitsyn', 1962, 27, '2025-02-18 01:28:37'),
       ('The Twelve Chairs', 'I. Ilf & E. Petrov', 1928, 26, '2025-03-01 12:10:13'),
       ('The Overcoat', 'N. Gogol', 1842, 37, '2025-02-09 06:32:32'),
       ('Anna Karenina', 'L. Tolstoy', 1878, 25, '2025-01-02 19:41:14'),
       ('Oblomov', 'I. Goncharov', 1859, 25, '2025-01-25 21:32:13'),
       ('A Hero of Our Time', 'M. Lermontov', 1840, 12, '2025-02-07 05:42:37'),
       ('The White Guard', 'M.A. Bulgakov', 1925, 8, '2025-02-08 01:30:38'),
       ('Heart of a Dog', 'M.A. Bulgakov', 1925, 21, '2025-01-30 22:00:24'),
       ('Dark Avenues', 'I. Bunin', 1946, 12, '2025-01-17 13:44:31'),
       ('To Kill a Mockingbird', 'Harper Lee', 1960, 46, '2025-01-26 21:37:58'),
       ('1984', 'George Orwell', 1949, 6, '2025-01-17 17:28:38'),
       ('The Great Gatsby', 'F. Scott Fitzgerald', 1925, 6, '2025-02-05 18:02:32'),
       ('Moby Dick', 'Herman Melville', 1851, 31, '2025-01-31 23:05:56'),
       ('Pride and Prejudice', 'Jane Austen', 1813, 48, '2025-02-12 23:15:43'),
       ('The Catcher in the Rye', 'J.D. Salinger', 1951, 25, '2025-01-09 18:34:20'),
       ('Ulysses', 'James Joyce', 1922, 28, '2025-02-09 23:10:36'),
       ('Brave New World', 'Aldous Huxley', 1932, 23, '2025-01-11 01:51:45'),
       ('The Hobbit', 'J.R.R. Tolkien', 1937, 4, '2025-03-09 01:08:18'),
       ('Fahrenheit 451', 'Ray Bradbury', 1953, 7, '2025-02-10 07:56:12'),
       ('One Hundred Years of Solitude', 'Gabriel García Márquez', 1967, 24, '2025-01-05 00:29:24'),
       ('Don Quixote', 'Miguel de Cervantes', 1605, 12, '2025-02-10 09:34:55'),
       ('The Odyssey', 'Homer', -700, 16, '2025-02-07 02:03:52'),
       ('The Divine Comedy', 'Dante Alighieri', 1320, 38, '2025-01-17 13:44:31'),
       ('Les Misérables', 'Victor Hugo', 1862, 30, '2025-02-16 09:11:45'),
       ('Jane Eyre', 'Charlotte Brontë', 1847, 12, '2025-02-19 18:37:57'),
       ('Wuthering Heights', 'Emily Brontë', 1847, 1, '2025-01-27 14:22:25'),
       ('Dracula', 'Bram Stoker', 1897, 28, '2025-02-14 20:16:10'),
       ('The Alchemist', 'Paulo Coelho', 1988, 2, '2025-02-01 02:07:33'),
       ('The Stranger', 'Albert Camus', 1942, 25, '2025-01-28 03:58:05'),
       ('Hamlet', 'William Shakespeare', 1603, 5, '2025-02-17 22:20:38'),
       ('Great Expectations', 'Charles Dickens', 1861, 10, '2025-03-01 16:30:17'),
       ('In Search of Lost Time', 'Marcel Proust', 1913, 8, '2025-02-20 10:11:43'),
       ('The Picture of Dorian Gray', 'Oscar Wilde', 1890, 24, '2025-01-31 19:05:22'),
       ('Heart of Darkness', 'Joseph Conrad', 1899, 37, '2025-02-25 14:49:36'),
       ('The Trial', 'Franz Kafka', 1925, 24, '2025-01-28 07:34:51'),
       ('Les Misérables', 'Victor Hugo', 1862, 28, '2025-03-06 08:15:42'),
       ('Animal Farm', 'George Orwell', 1945, 22, '2025-01-10 11:22:33'),
       ('Fahrenheit 451', 'Ray Bradbury', 1953, 14, '2025-02-22 07:29:44'),
       ('Great Expectations', 'Charles Dickens', 1861, 33, '2025-01-12 05:11:27');