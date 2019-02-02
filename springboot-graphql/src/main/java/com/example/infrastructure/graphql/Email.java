package com.example.infrastructure.graphql;

public class Email {
    String value;
    public Email(String value) {
        System.out.println(value);
        this.value = value;
    }

    public String value() {
        return value;
    }

    public String toString() {
        return value;
    }
}
