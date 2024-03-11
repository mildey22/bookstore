package com.example.bookstore.model;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long categoryId;
private String name;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
private List<Book> books;

public Category() {}

    public Category(String name) {
        super();
        this.name = name;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "{" +
            " categoryId='" + getCategoryId() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
    

}
