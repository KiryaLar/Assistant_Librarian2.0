create table person
(
    id      serial primary key,
    name    varchar(64) not null,
    birth_year     int check ( age > 0 ),
    email   varchar unique,
    address varchar(128)
);

create table book
(
    id        serial primary key,
    title     varchar(256) not null,
    author    varchar(64)  not null,
    year      smallint     not null,
    person_id int          references person (id) on delete set null
);