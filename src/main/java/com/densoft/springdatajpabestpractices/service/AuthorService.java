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
                .name("Joana Nimar")
                .age(34)
                .genre("History")
                .addBook(new Book()
                        .title("A History of Ancient Prague")
                        .isbn("001-JN"))
                .addBook(new Book()
                        .title("A People's History")
                        .isbn("002-JN"));
        authorRepo.save(author);
        log.info("created author: {}", author);
    }

    public void addBookToAuthor() {
//        assuming we have existing author
        Author author = authorRepo.findById(1L).orElseThrow();
        Book book = new Book();
        book.setIsbn("001-MJ");
        book.setTitle("The Canterbury Anthology");
        book.setAuthor(author);
        bookRepo.save(book);
    }
}
