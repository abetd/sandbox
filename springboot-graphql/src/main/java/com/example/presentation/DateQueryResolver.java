package com.example.presentation;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateQueryResolver implements GraphQLQueryResolver {

    public LocalDate today() {
        return LocalDate.now();
    }

    public ThreeDays getThreeDays() {
        return new ThreeDays();
    }
}
