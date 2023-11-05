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
    void deleteViaCascadeRemove() {
        authorService.deleteViaCascadeRemove();
    }

    @Test
    void deleteViaIdentifiers() {
        authorService.deleteViaIdentifiers();
    }

    @Test
    void deleteViaBulkIn() {
        authorService.deleteViaBulkIn();
    }

    @Test
    void deleteViaDeleteInBatch() {
        authorService.deleteViaDeleteInBatch();
    }

    @Test
    void deleteViaHardCodedIdentifiers() {
        authorService.deleteViaHardCodedIdentifiers();
    }

    @Test
    void deleteViaBulkHardCodedIdentifiers() {
        authorService.deleteViaBulkHardCodedIdentifiers();
    }

    @Test
    void findAllAuthors() {
        authorService.findAllAuthors();
    }

    @Test
    void findAllAuthorsWhereAgeIsGreaterThan() {
        authorService.findAllAuthorsWhereAgeIsGreaterThan();
    }

    @Test
    void findAllAuthorsWhereAgeIsGreaterThan45Specification() {
        authorService.findAllAuthorsWhereAgeIsGreaterThan45Specification();
    }

    @Test
    void fetchAllAgeBetween20And40() {
        authorService.fetchAllAgeBetween20And40();
    }
}