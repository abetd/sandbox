package com.example.presentation;

import com.example.infrastructure.graphql.Email;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArgumentAuthor {
    @JsonProperty
    String name;

    @JsonProperty
    Email email;
}
