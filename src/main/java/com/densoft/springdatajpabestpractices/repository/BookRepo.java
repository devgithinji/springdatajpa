package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Author;
import com.densoft.springdatajpabestpractices.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BookRepo extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM Book b WHERE b.author.id = ?1")
    int deleteByAuthorIdentifier(Long id);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM Book b WHERE b.author IN ?1")
    int deleteBulkByAuthors(List<Author> authors);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM Book b WHERE b.author.id IN ?1")
    public int deleteBulkByAuthorIdentifier(List<Long> id);
}
