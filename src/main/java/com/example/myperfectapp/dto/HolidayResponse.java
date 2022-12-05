package com.example.myperfectapp.dto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class HolidayResponse {

    private String name;
    private LocalDate date;
    public HolidayResponse() {
    }

    public HolidayResponse(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HolidayResponse that)) return false;
        return name.equals(that.name) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date);
    }
}
