package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    @Transactional
    public void insertAuthorWithBooks() {
        Book jn01 = new Book();
        jn01.setIsbn("001-JN");
        jn01.setTitle("A history of Ancient Prague");

        Book jn02 = new Book();
        jn02.setIsbn("002-JN");
        jn02.setTitle("A People's History");

        Book jn03 = new Book();
        jn03.setIsbn("003-JN");
        jn03.setTitle("World History");

        Author jn = new Author();
        jn.setName("Joana Nimar");
        jn.setAge(34);
        jn.setGenre("History");
        jn.addBook(jn01);
        jn.addBook(jn02);
        jn.addBook(jn03);

        authorRepo.save(jn);

    }

    @Transactional
    public void deleteViaCascadeRemove() {
        Author author = authorRepo.findByName("Joana Nimar");
        authorRepo.delete(author);
    }


}
