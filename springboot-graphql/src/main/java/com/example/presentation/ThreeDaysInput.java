package com.example.presentation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.Serializable;
import java.time.LocalDate;

public class ThreeDaysInput {

    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty
    public LocalDate today;

    public ThreeDaysInput() {
        System.out.println("ThreeDaysInput()");
    }
}
