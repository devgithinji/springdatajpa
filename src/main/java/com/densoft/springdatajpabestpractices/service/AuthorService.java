package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.model.Publisher;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import com.densoft.springdatajpabestpractices.repository.PublisherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    @Transactional
    public void insertAuthorWithBooks() {
        Publisher p1 = new Publisher();
        p1.setCompany("cp-01");

        Publisher p2 = new Publisher();
        p2.setCompany("cp-02");

        publisherRepo.saveAll(List.of(p1, p2));

        Book jn01 = new Book();
        jn01.setIsbn("001-JN");
        jn01.setTitle("A history of Ancient Prague");
        jn01.setPublisher(p1);

        Book jn02 = new Book();
        jn02.setIsbn("002-JN");
        jn02.setTitle("A People's History");
        jn02.setPublisher(p1);

        Book jn03 = new Book();
        jn03.setIsbn("003-JN");
        jn03.setTitle("World History");
        jn03.setPublisher(p2);

        Author jn = new Author();
        jn.setName("Joana Nimar");
        jn.setAge(34);
        jn.setGenre("History");
        jn.addBook(jn01);
        jn.addBook(jn02);
        jn.addBook(jn03);


        Author pk = new Author();
        pk.setName("Paul kamau");
        pk.setAge(20);
        pk.setGenre("Education");

        Book pk01 = new Book();
        pk01.setIsbn("001-PK");
        pk01.setTitle("Geography");
        pk01.setPublisher(p1);

        Book pk02 = new Book();
        pk02.setIsbn("002-PK");
        pk02.setTitle("Religion");
        pk02.setPublisher(p2);

        pk.addBook(pk01);
        pk.addBook(pk02);

        authorRepo.saveAll(List.of(jn, pk));

    }

    public void findByAgeGreaterThanAndGenre() {
        authorRepo.findByAgeGreaterThanAndGenre(33, "History");
    }

    public void findByGenreAndAgeGreaterThan() {
        authorRepo.findByGenreAndAgeGreaterThan("Education", 15);
    }


}
