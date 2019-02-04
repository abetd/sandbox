package com.example.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ThreeDaysInput {

    @JsonProperty("today")
    public LocalDate today;
}
