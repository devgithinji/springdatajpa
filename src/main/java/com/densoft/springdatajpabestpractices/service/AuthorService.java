package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.dto.AuthorDto;
import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.repository.AuthorRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .email("test@gmail.com")
                .address("limuru")
                .addBook(new Book()
                        .title("A History of Ancient Prague")
                        .isbn("001-JN"))
                .addBook(new Book()
                        .title("A People's History")
                        .isbn("002-JN"));


        Author author1 = new Author().name("Dennis Githinji").age(56).genre("History");
        Author author2 = new Author().name("paul wakahia").age(46).genre("Maths");

        authorRepo.saveAll(List.of(author, author1, author2));
    }


    public void fetchByGenre() {
        List<AuthorDto> authorDto = authorRepo.findByGenre("History");
        listToString(authorDto);
    }

    public void fetchAuthors() {
        List<AuthorDto> authorDto = authorRepo.fetchAuthors();
        listToString(authorDto);
    }

    public static <T> void listToString(T authorDtoList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(authorDtoList));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // Handle the exception according to your needs
            log.error("Error converting to JSON");
        }
    }


}
