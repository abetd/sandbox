package com.example.domain;

public class Book {
    int id;
    String name;
    Author author;

    public Book(int id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
