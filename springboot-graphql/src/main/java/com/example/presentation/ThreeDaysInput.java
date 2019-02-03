package com.example.presentation;

import com.example.infrastructure.graphql.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.time.LocalDate;

public class ThreeDaysInput implements Serializable {

    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate today;

}
