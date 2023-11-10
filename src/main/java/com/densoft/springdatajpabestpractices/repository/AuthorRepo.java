package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.dto.AuthorDto;
import com.densoft.springdatajpabestpractices.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Long>, JpaSpecificationExecutor<Author> {
    @Query("SELECT a FROM Author a WHERE a.name = :name")
    Author fetchByName(@Param("name") String name);

    Author findByName(String name);

    List<Author> findByAge(int age);

    List<AuthorDto> findBy();

    //fetch all data
    @Query("SELECT a.age AS age, a.name AS name, a.genre AS genre, "
            + "a.email AS email, a.address AS address FROM Author a")
    List<AuthorDto> fetchAll();

    //fetch age, name and genre
    @Query("SELECT a.age AS age, a.name AS name, a.genre AS genre FROM Author a")
    List<AuthorDto> fetchAgeNameGenre();

    //    fetch name and email
    @Query("SELECT a.name AS name, a.email AS email FROM Author a")
    List<AuthorDto> fetchNameEmail();

//    spring dynamic projections
    <T> T findByName(String name, Class<T> type);
    <T> List<T> findByGenre(String genre, Class<T> type);
    @Query("SELECT a FROM Author a WHERE a.name=?1 AND a.age=?2")
    <T> T findByNameAndAge(String name, int age, Class<T> type);

    interface AuthorGenreDto {
        String getGenre();
    }

    interface AuthorNameEmailDto {
        String getName();
        String getEmail();
    }

}
