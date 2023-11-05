package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.model.Author;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    @Query("SELECT a FROM Author a WHERE a.name = :name")
    Author fetchByName(@Param("name") String name);

    Author findByName(String name);

    List<Author> findByAge(int age);


    @Override
    @EntityGraph(value = "author-books-publisher-graph",
            type = EntityGraph.EntityGraphType.FETCH)
    List<Author> findAll();


    @EntityGraph(value = "author-books-graph",
            type = EntityGraph.EntityGraphType.FETCH)
    List<Author> findByAgeLessThanOrderByNameDesc(int age);


    @EntityGraph(value = "author-books-publisher-graph",
            type = EntityGraph.EntityGraphType.FETCH)
    @Query(value="SELECT a FROM Author a WHERE a.age > 20 AND a.age<40")
    public List<Author> fetchAllAgeBetween20And40();

    @Override
    @Modifying(clearAutomatically = true)
    void deleteAllInBatch(Iterable<Author> entities);

    @Query("SELECT a FROM Author a LEFT JOIN Book b ON a.id = b.author.id WHERE a.name = :name")
    Author findByNameWithBooks(@Param("name") String name);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM Author a WHERE a.id = ?1")
    int deleteByIdentifier(Long id);


    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM Author a WHERE a.id IN ?1")
    int deleteBulkByIdentifier(List<Long> id);


}
