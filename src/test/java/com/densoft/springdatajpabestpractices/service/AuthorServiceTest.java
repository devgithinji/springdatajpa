package com.densoft.springdatajpabestpractices.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    void createAuthor() {
        authorService.createAuthor();
    }


    @Test
    void fetchAll() {
        authorService.fetchAll();
    }

    @Test
    void fetchAgeNameGenre() {
        authorService.fetchAgeNameGenre();
    }

    @Test
    void fetchNameAndEmail() {
        authorService.fetchNameAndEmail();
    }

    @Test
    void fetchByName() {
        authorService.fetchByName();
    }

    @Test
    void fetchByAge() {
        authorService.fetchByAge();
    }
}