package com.example.domain;

public class Book {
    int id;
    String name;
    int authorId;

    public Book(int id, String name, int authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
    }

    public Book() {}
}
