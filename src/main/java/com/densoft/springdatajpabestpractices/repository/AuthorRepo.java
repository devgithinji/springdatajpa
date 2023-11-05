package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.name = :name")
    Author fetchByName(@Param("name") String name);

    Author findByName(String name);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM Author a WHERE a.id = ?1")
    int deleteByIdentifier(Long id);
}
