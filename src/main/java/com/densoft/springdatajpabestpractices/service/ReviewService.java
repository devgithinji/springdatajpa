package com.densoft.springdatajpabestpractices.service;

import com.densoft.springdatajpabestpractices.model.Review;
import com.densoft.springdatajpabestpractices.repository.ArticleRepo;
import com.densoft.springdatajpabestpractices.repository.BookRepo;
import com.densoft.springdatajpabestpractices.repository.MagazineRepo;
import com.densoft.springdatajpabestpractices.repository.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final BookRepo bookRepo;
    private final ArticleRepo articleRepo;
    private final MagazineRepo magazineRepo;

    @Transactional
    public void persistReviewOk() {
        Review review = new Review();
        review.setContent("This is a book review ...");
        review.setBook(bookRepo.findById(1L).get());
        reviewRepo.save(review);
    }

    @Transactional
    public void persistReviewWrong() {
        Review review = new Review();
        review.setContent("This is an article and magazine review ...");
        review.setArticle(articleRepo.findById(1L).get());
        // this will fail validation
        review.setMagazine(magazineRepo.findById(1L).get());
        reviewRepo.save(review);
    }
}
