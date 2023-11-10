package com.densoft.springdatajpabestpractices.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public interface AuthorDto {
    Integer getAge();

    String getName();

    String getGenre();

    String getEmail();

    String getAddress();

}
