create database spring_library;

use spring_library;

create table members (
                         id int auto_increment primary key ,
                         name varchar(100),
                         hobby varchar(100),
                         address text
);

create table books (
                       id int auto_increment primary key ,
                       name varchar(100),
                       author varchar(100),
                       description text,
                       is_borrowed bool,
                       created_timestamp timestamp
);

create table borrowings (
                            id int auto_increment primary key,
                            member_id int,
                            book_id int,
                            created_timestamp timestamp,
                            foreign key fk_borrowings_member (member_id) references members (id) on DELETE restrict on update cascade ,
                            foreign key fk_borrowings_book (book_id) references books (id) on DELETE restrict on update cascade

)

