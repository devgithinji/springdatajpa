package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        jn01.setPrice(25);

        Author jn = new Author();
        jn.setName("Joana Nimar");
        jn.setAge(34);
        jn.setGenre("History");
        jn.setBook(jn01);


        Author pk = new Author();
        pk.setName("Paul kamau");
        pk.setAge(20);
        pk.setGenre("Education");

        Book pk01 = new Book();
        pk01.setIsbn("001-PK");
        pk01.setTitle("Geography");
        pk01.setPrice(27);
        pk.setBook(pk01);


        authorRepo.saveAll(List.of(jn, pk));

    }

    public void getAuthor() {
        Author author = authorRepo.findById(1L).orElseThrow();
    }


}
