package com.example.bookinfo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    @JsonIgnore
    @ManyToMany
    private Set<Author> authorSet;
    @ManyToOne
    private Category category;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}
