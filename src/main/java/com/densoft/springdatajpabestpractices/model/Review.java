package com.densoft.springdatajpabestpractices.model;

import com.densoft.springdatajpabestpractices.validators.JustOneOfMany;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@JustOneOfMany
public class Review implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    private Magazine magazine;
    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;
}
