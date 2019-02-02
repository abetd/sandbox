package com.example.presentation;

import com.example.infrastructure.graphql.Email;

public class ArgumentAuthor {
    String name;
    Email email;

    public ArgumentAuthor() {
        System.out.println("ArgumentAuthor()");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = new Email(email.value());
    }
}
