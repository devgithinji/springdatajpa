package com.densoft.springdatajpabestpractices.repository;

import com.densoft.springdatajpabestpractices.dto.AuthorDto;
import com.densoft.springdatajpabestpractices.model.Author;
import org.springframework.beans.factory.annotation.Value;
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
    List<AuthorDto> findByGenre(String genre);

    // Constructor Expression
    @Query(value = "SELECT new com.densoft.springdatajpabestpractices.dto.AuthorDto(a.name, a.age) FROM Author a")
    List<AuthorDto> fetchAuthors();

    //    fetch name and email
    @Query("SELECT a.name AS name, a.email AS email FROM Author a")
    List<AuthorDto> fetchNameEmail();

    //    spring dynamic projections
    <T> T findByName(String name, Class<T> type);

    <T> List<T> findByGenre(String genre, Class<T> type);

    @Query("SELECT a FROM Author a WHERE a.name=?1 AND a.age=?2")
    <T> T findByNameAndAge(String name, int age, Class<T> type);

    @Query("SELECT a.name AS name, a.age AS age FROM Author a WHERE a.age>=?1")
    List<AuthorNameAge> fetchByAge(int age);

    interface AuthorGenreDto {
        String getGenre();
    }

    interface AuthorNameEmailDto {
        String getName();

        String getEmail();
    }

    interface AuthorNameAge {
        String getName();

        @Value("#{target.age}")
        String years();

        @Value("#{ T(java.lang.Math).random() * 10000 }")
        int rank();

        @Value("5")
        String books();
    }

}
