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
        Author jn = new Author();
        jn.setName("Joana Nimar");
        jn.setAge(34);
        jn.setGenre("History");

        authorRepo.save(jn);


        Book jn01 = new Book();
        jn01.setIsbn("001-JN");
        jn01.setTitle("A history of Ancient Prague");
        jn01.setAuthor(jn);

        Book jn02 = new Book();
        jn02.setIsbn("002-JN");
        jn02.setTitle("A People's History");
        jn02.setAuthor(jn);

        Book jn03 = new Book();
        jn03.setIsbn("003-JN");
        jn03.setTitle("World History");
        jn03.setAuthor(jn);


        bookRepo.saveAll(List.of(jn01,jn02,jn03));
    }

    @Transactional
    public void insertNewBook() {
        Author author = authorRepo.getReferenceById(1L);
        Book book = new Book();
        book.setIsbn("003-JN");
        book.setTitle("History Of Present");
        book.setAuthor(author);
        bookRepo.save(book);
    }

    @Transactional
    public void insertNewBookDc() {
        Author author = authorRepo.getReferenceById(1L);
        Book book = new Book();
        book.setIsbn("004-JN");
        book.setTitle("History Of Past");
        book.setAuthor(author);
        bookRepo.save(book);

        book.setIsbn("not available");
    }

    @Transactional
    public void deleteLastBook() {
//        Author author = authorRepo.fetchByName("Joana Nimar");
//        List<Book> books = author.getBooks();
//        // use removeBook() helper
//        author.removeBook(books.get(books.size() - 1));
    }

    @Transactional
    public void deleteFirstBook() {
//        Author author = authorRepo.fetchByName("Joana Nimar");
//        List<Book> books = author.getBooks();
//        author.removeBook(books.get(0));
    }

}
