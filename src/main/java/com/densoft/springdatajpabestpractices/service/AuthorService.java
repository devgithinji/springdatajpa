package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    @PostConstruct
    private void setup() {
        Optional<Author> optionalAuthor = authorRepo.findById(1L);
        System.out.println("here");
        if (optionalAuthor.isEmpty()){
            Author author = new Author();
            author.setName("John doe");
            author.setGenre("education");
            author.setAge(30);
            authorRepo.save(author);
        }
    }

    @Transactional
    public void newBookOfAuthor() {

        Author author = authorRepo.findById(1L).orElseThrow();
        Book book = new Book();
        book.setTitle("A History of Ancient Prague");
        book.setIsbn("001-JN");
        // this will set the id of the book as the id of the author
        book.setAuthor(author);
        bookRepo.save(book);
    }

    @Transactional(readOnly = true)
    public Book fetchBookByAuthorId() {
        Author author = authorRepo.findById(1L).orElseThrow();
        return bookRepo.findById(author.getId()).orElseThrow();
    }


}
