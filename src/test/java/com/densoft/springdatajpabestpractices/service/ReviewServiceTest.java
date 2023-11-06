package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Article;
import com.densoft.springdatajpabestpractices.model.Book;
import com.densoft.springdatajpabestpractices.model.Magazine;
import com.densoft.springdatajpabestpractices.repository.ArticleRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import com.densoft.springdatajpabestpractices.repository.MagazineRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReviewServiceTest {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private MagazineRepo magazineRepo;
    @Autowired
    private ArticleRepo articleRepo;
    @Autowired
    private BookRepo bookRepo;

    @BeforeEach
    private void setup() {
        Book book = new Book();
        book.setIsbn("IS-001");
        book.setPrice(34);
        book.setTitle("World Apart");
        bookRepo.save(book);

        Magazine magazine = new Magazine();
        magazine.setContent("taifa leo");
        magazineRepo.save(magazine);

        Article article = new Article();
        article.setContent("sport today");
        articleRepo.save(article);

    }

    @Test
    void persistReviewOk() {
        reviewService.persistReviewOk();
    }

    @Test
    void persistReviewWrong() {
        reviewService.persistReviewWrong();
    }
}