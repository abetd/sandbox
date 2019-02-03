package com.example.infrastructure.graphql;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Email {
    @JsonProperty
    String value;

    public Email() {
    }

    public Email(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
