package com.example.myperfectapp.dto;

<<<<<<< HEAD
<<<<<<< HEAD
import java.time.LocalDate;
=======
>>>>>>> 250cd76 (Changed app structure)
=======
import java.time.LocalDate;
>>>>>>> b553233 (changed service class)
import java.util.Arrays;
import java.util.Objects;

public class HolidayResponse {

    private String name;
<<<<<<< HEAD
<<<<<<< HEAD
    private LocalDate date;
    public HolidayResponse() {
    }

    public HolidayResponse(String name, LocalDate date) {
        this.name = name;
        this.date = date;
=======
    private String date;
    private String countryCode;
    private String[] counties;

=======
    private LocalDate date;
>>>>>>> b553233 (changed service class)
    public HolidayResponse() {
    }

    public HolidayResponse(String name, LocalDate date) {
        this.name = name;
        this.date = date;
<<<<<<< HEAD
        this.countryCode = countryCode;
        this.counties = counties;
>>>>>>> 250cd76 (Changed app structure)
=======
>>>>>>> b553233 (changed service class)
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public LocalDate getDate() {
        return date;
    }

=======
    public String getDate() {
        return date;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String[] getCounties() {
        return counties;
    }

>>>>>>> 250cd76 (Changed app structure)
=======
    public LocalDate getDate() {
        return date;
    }

>>>>>>> b553233 (changed service class)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HolidayResponse that)) return false;
<<<<<<< HEAD
<<<<<<< HEAD
        return name.equals(that.name) && date.equals(that.date);
=======
        return name.equals(that.name) && date.equals(that.date) && countryCode.equals(that.countryCode) && Arrays.equals(counties, that.counties);
>>>>>>> 250cd76 (Changed app structure)
=======
        return name.equals(that.name) && date.equals(that.date);
>>>>>>> b553233 (changed service class)
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
<<<<<<< HEAD
        return Objects.hash(name, date);
=======
        int result = Objects.hash(name, date, countryCode);
        result = 31 * result + Arrays.hashCode(counties);
        return result;
>>>>>>> 250cd76 (Changed app structure)
=======
        return Objects.hash(name, date);
>>>>>>> b553233 (changed service class)
    }
}
