package com.densoft.springdatajpabestpractices.dto;

public class AuthorDto {
    private final String name;
    private final int age;

    public AuthorDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
