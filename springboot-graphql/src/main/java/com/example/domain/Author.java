package com.example.domain;

public class Author {
    int id;
    String name;
    String email;

    public Author(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return this.id;
    }
}
