package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Publisher;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    @Override
    @EntityGraph(attributePaths = {"books.author"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Publisher> findAll();

    @EntityGraph(attributePaths = {"books.author"},
            type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT p FROM Publisher p WHERE p.id > 1 AND p.id < 3")
    List<Publisher> fetchAllIdBetween1And3();
}
