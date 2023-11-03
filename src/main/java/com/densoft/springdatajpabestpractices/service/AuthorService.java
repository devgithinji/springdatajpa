package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;

    @Transactional
    public void insertAuthorWithBooks() {
        Author jn = new Author();
        jn.setName("Joana Nimar");
        jn.setAge(34);
        jn.setGenre("History");

        Book jn01 = new Book();
        jn01.setIsbn("001-JN");
        jn01.setTitle("A history of Ancient Prague");

        Book jn02 = new Book();
        jn02.setIsbn("002-JN");
        jn02.setTitle("A People's History");

        Book jn03 = new Book();
        jn03.setIsbn("003-JN");
        jn03.setTitle("World History");

        jn.addBook(jn01);
        jn.addBook(jn02);
        jn.addBook(jn03);

        authorRepo.save(jn);
    }

    @Transactional
    public void insertNewBook() {
        Author author = authorRepo.fetchByName("Joana Nimar");
        Book book = new Book();
        book.setIsbn("004-JN");
        book.setTitle("History Details");
        author.addBook(book); // use addBook() helper
        authorRepo.save(author);
    }

    @Transactional
    public void deleteLastBook() {
        Author author = authorRepo.fetchByName("Joana Nimar");
        List<Book> books = author.getBooks();
        // use removeBook() helper
        author.removeBook(books.get(books.size() - 1));
    }

    @Transactional
    public void deleteFirstBook() {
        Author author = authorRepo.fetchByName("Joana Nimar");
        List<Book> books = author.getBooks();
        author.removeBook(books.get(0));
    }

}
