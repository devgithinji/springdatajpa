package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public void createAuthor() {
        Author author = new Author()
                .setName("Joana Nimar")
                .setAge(34)
                .setGenre("History")
                .addBook(new Book()
                        .setTitle("A History of Ancient Prague")
                        .setIsbn("001-JN"))
                .addBook(new Book()
                        .setTitle("A People's History")
                        .setIsbn("002-JN"));
        authorRepo.save(author);
        log.info("created author: {}",author);
    }
}
