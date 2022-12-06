package com.example.myperfectapp;

import com.example.myperfectapp.dto.HolidayResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppService {
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
