package com.densoft.springdatajpabestpractices.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter
@Setter
public class Author implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String genre;
    private int age;


    @Override
    public String toString() {
        String sb = "Author{" + "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
        return sb;
    }
}
