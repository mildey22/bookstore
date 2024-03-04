package com.example.bookstore.model;

import jakarta.persistence.*;


@Entity
public class Book {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String title;
private String author;
@Column(name="publishing_year")
private int year;
private String isbn;
private double price;

@ManyToOne
@JoinColumn(name = "categoryId")
private Category category;

public Book() {}

    public Book(String title, String author, int year, String isbn, double price, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", year='" + getYear() + "'" +
            ", isbn='" + getIsbn() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }


}
