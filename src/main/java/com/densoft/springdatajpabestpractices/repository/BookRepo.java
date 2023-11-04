package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
