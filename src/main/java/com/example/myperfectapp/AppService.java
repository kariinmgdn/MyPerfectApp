package com.example.myperfectapp;

import com.example.myperfectapp.dto.HolidayResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> 250cd76 (Changed app structure)
=======
>>>>>>> b553233 (changed service class)
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

<<<<<<< HEAD
<<<<<<< HEAD
import java.time.LocalDate;
import java.util.*;
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
>>>>>>> 250cd76 (Changed app structure)
=======
import java.time.LocalDate;
import java.util.*;
>>>>>>> b553233 (changed service class)
import java.util.stream.Collectors;

@Service
public class AppService {

<<<<<<< HEAD
<<<<<<< HEAD
    public List<String> getCommonHolidays(String first, String second, String year) {
        HolidayResponse[] firstCountryHolidays = callAPI(first, year);
        HolidayResponse[] secondCountryHolidays = callAPI(second, year);

        List<String> commonHolidays = new ArrayList<>();

        for (HolidayResponse firstHoliday : firstCountryHolidays) {
            HashSet<LocalDate> dates = new HashSet<>();
            for (HolidayResponse secondHoliday : secondCountryHolidays) {
                if (firstHoliday.getName().equals(secondHoliday.getName())) {
                    dates.add(firstHoliday.getDate());
                    dates.add(secondHoliday.getDate());
                }
            }
            if (dates.size() > 0) {
                commonHolidays.add(firstHoliday.getName() + ": " + dates.stream()
                        .map(LocalDate::toString)
                        .collect(Collectors.joining(", ")));
            }
        }

        return commonHolidays;
    }

    public HolidayResponse[] callAPI(String country, String year) {
=======
    public List<StringBuilder> getCommonHolidays(@PathVariable String first,
                                                 @PathVariable String second,
                                                 @PathVariable String year) {
=======
    public List<String> getCommonHolidays(String first, String second, String year) {
        HolidayResponse[] firstCountryHolidays = callAPI(first, year);
        HolidayResponse[] secondCountryHolidays = callAPI(second, year);
>>>>>>> b553233 (changed service class)

        List<String> commonHolidays = new ArrayList<>();

        for (HolidayResponse firstHoliday : firstCountryHolidays) {
            HashSet<LocalDate> dates = new HashSet<>();
            for (HolidayResponse secondHoliday : secondCountryHolidays) {
                if (firstHoliday.getName().equals(secondHoliday.getName())) {
                    dates.add(firstHoliday.getDate());
                    dates.add(secondHoliday.getDate());
                }
            }
            if (dates.size() > 0) {
                commonHolidays.add(firstHoliday.getName() + ": " + dates.stream()
                        .map(LocalDate::toString)
                        .collect(Collectors.joining(", ")));
            }
        }

        return commonHolidays;
    }

<<<<<<< HEAD
    private HolidayResponse[] callAPI(String country, String year) {
>>>>>>> 250cd76 (Changed app structure)
=======
    public HolidayResponse[] callAPI(String country, String year) {
>>>>>>> b553233 (changed service class)
        try {
            return WebClient
                    .create("https://date.nager.at/Api/v2/PublicHolidays/" + year + "/" + country)
                    .get()
                    .retrieve()
                    .bodyToMono(HolidayResponse[].class)
                    .log()
                    .block();
        } catch (WebClientResponseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
