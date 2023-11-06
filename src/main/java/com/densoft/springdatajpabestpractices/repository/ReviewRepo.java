package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}
