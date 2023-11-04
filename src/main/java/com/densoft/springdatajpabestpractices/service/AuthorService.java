package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public void insertNewBook() {
        Author author = authorRepo.getReferenceById(1L);
        Book book = new Book();
        book.setIsbn("003-JN");
        book.setTitle("History Of Present");

        author.addBook(book);
    }

    @Transactional
    public void insertNewBookDc() {
        Author author = authorRepo.getReferenceById(1L);
        Book book = new Book();
        book.setIsbn("004-JN");
        book.setTitle("History Of Past");

        author.addBook(book);

        book.setIsbn("not available");
    }

    @Transactional
    public void deleteLastBook() {
        Author author = authorRepo.fetchByName("Joana Nimar");
        System.out.println(author.getBooks());
        List<Book> books = new ArrayList<>(author.getBooks());
        // use removeBook() helper
        author.removeBook(books.get(books.size() - 1));
//        authorRepo.save(author);
    }

    @Transactional
    public void deleteFirstBook() {
        Author author = authorRepo.fetchByName("Joana Nimar");
        List<Book> books = new ArrayList<>(author.getBooks());
        author.removeBook(books.get(0));
        authorRepo.save(author);
    }

    @Transactional
    public void deleteBook(){
        Author author = authorRepo.fetchByName("Joana Nimar");
        Book book = bookRepo.findById(2L).get();
        author.removeBook(book);
    }

}
