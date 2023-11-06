package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
