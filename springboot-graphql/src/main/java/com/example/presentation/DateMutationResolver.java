package com.example.presentation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateMutationResolver implements GraphQLMutationResolver {

    // setDay(day: Date): Date
    public LocalDate setDay(LocalDate day) {
        return LocalDate.now().minusDays(5);
    }

    // setThreeDays(threeDays: ThreeDaysInput): ThreeDays
    public ThreeDays setThreeDays(ThreeDaysInput threeDaysInput) {
        ThreeDays result = new ThreeDays();
        result.today = threeDaysInput.today;
        return result;
    }
}
