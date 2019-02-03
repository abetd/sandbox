package com.example.presentation;

import java.time.LocalDate;

public class ThreeDays {
    LocalDate tommorow = LocalDate.now().plusDays(1);
    LocalDate today = LocalDate.now();
    LocalDate yesterday = LocalDate.now().minusDays(1);
}
