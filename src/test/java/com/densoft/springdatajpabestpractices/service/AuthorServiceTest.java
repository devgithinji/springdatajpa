package com.densoft.springdatajpabestpractices.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void insertAuthorWithBooks() {
        authorService.insertAuthorWithBooks();
    }

    @Test
    void findByAgeGreaterThanAndGenre() {
        authorService.findByAgeGreaterThanAndGenre();
    }

    @Test
    void findByGenreAndAgeGreaterThan() {
        authorService.findByGenreAndAgeGreaterThan();
    }
}