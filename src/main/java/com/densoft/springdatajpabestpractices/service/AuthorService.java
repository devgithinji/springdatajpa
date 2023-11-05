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


        Author pk = new Author();
        pk.setName("Paul kamau");
        pk.setAge(34);
        pk.setGenre("Education");

        Book pk01 = new Book();
        pk01.setIsbn("001-PK");
        pk01.setTitle("Geography");

        Book pk02 = new Book();
        pk02.setIsbn("002-PK");
        pk02.setTitle("Religion");

        pk.addBook(pk01);
        pk.addBook(pk02);

        authorRepo.saveAll(List.of(jn, pk));


    }

    @Transactional
    public void deleteViaCascadeRemove() {
        Author author = authorRepo.findByName("Joana Nimar");
        authorRepo.delete(author);
    }

    @Transactional
    public void deleteViaIdentifiers() {
        Author author = authorRepo.findByName("Joana Nimar");
        bookRepo.deleteByAuthorIdentifier(author.getId());
        authorRepo.deleteByIdentifier(author.getId());
//        alternative
//        authorRepo.deleteAllInBatch(List.of(author));
    }

    @Transactional
    public void deleteViaBulkIn() {
        List<Author> authors = authorRepo.findByAge(34);
        bookRepo.deleteBulkByAuthors(authors);
        authorRepo.deleteAllInBatch(authors);
    }

    @Transactional
    public void deleteViaDeleteInBatch() {
        Author author = authorRepo.findByNameWithBooks("Joana Nimar");
//      deleteAllInBatch does not flush or clear the persistence context it may leave the persistence context in outdated state
//        no problem here cause after the deletion operations the transaction commits
        bookRepo.deleteAllInBatch(author.getBooks());
        authorRepo.deleteAllInBatch(List.of(author));
// later on, we forgot that this author was deleted
//        author.setGenre("Anthology");

    }


}
