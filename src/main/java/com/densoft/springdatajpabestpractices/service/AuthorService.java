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
        authorRepo.save(author);
        log.info("created author: {}", author);
    }

    public void fetchAll() {
        List<AuthorDto> authorDto = authorRepo.fetchAll();
        System.out.println(listToString(authorDto));
    }

    public void fetchAgeNameGenre() {
        List<AuthorDto> authorDto = authorRepo.fetchAgeNameGenre();
        System.out.println(listToString(authorDto));
    }

    public void fetchNameAndEmail() {
        List<AuthorDto> authorDto = authorRepo.fetchNameEmail();
        System.out.println(listToString(authorDto));
    }


    public static String listToString(List<AuthorDto> authorDtoList) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(authorDtoList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // Handle the exception according to your needs
            return "Error converting to JSON";
        }
    }
}
