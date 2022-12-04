package com.example.myperfectapp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/myperfectapp")
public class AppController {

    @GetMapping("/{first}/{second}/{year}")
    public List<StringBuilder> getCommonHolidays(@PathVariable String first,
                                                 @PathVariable String second,
                                                 @PathVariable String year) {

        HashMap<String, List<StringBuilder>> firstCountryHolidays = getCountryHolidays(first, year);
        HashMap<String, List<StringBuilder>> secondCountryHolidays = getCountryHolidays(second, year);

        return firstCountryHolidays.keySet()
                .stream()
                .filter(secondCountryHolidays::containsKey)
                .map(holiday -> new StringBuilder(holiday)
                        .append(": ")
                        .append(String.join(", ", firstCountryHolidays.get(holiday)))
                        .append(", ")
                        .append(String.join(", ", secondCountryHolidays.get(holiday))))
                .collect(Collectors.toList());
    }

    private HashMap<String, List<StringBuilder>> getCountryHolidays(String country, String year) {

        JSONArray allHolidays = new JSONArray(callAPI(country, year));
        HashMap<String, List<StringBuilder>> holidays = new HashMap<>();

        List<StringBuilder> dates;

        for (int i = 0; i < allHolidays.length(); i++) {
            JSONObject holiday = allHolidays.getJSONObject(i);
            String countryCode = holiday.get("countryCode").toString();

            if (!holiday.get("counties").toString().equals("null")) {
                countryCode = String.join(", ", holiday
                        .get("counties").toString()
                        .replaceAll("[^A-Z,-]", "")
                        .split(","));
            }

            String name = holiday.get("name").toString();
            StringBuilder date = new StringBuilder(holiday.get("date")
                    .toString()).append(" (").append(countryCode).append(")");

            if (holidays.containsKey(name)) {
                dates = holidays.get(name);
                dates.add(date);
            } else {
                dates = new ArrayList<>();
                dates.add(date);
                holidays.put(name, dates);
            }
        }
        return holidays;
    }

    private String callAPI(String country, String year) {

        try {
            String urlInput = "https://date.nager.at/Api/v2/PublicHolidays/" + year + "/" + country;
            URL url = new URL(urlInput);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuilder inputData = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                inputData.append(inputLine);
            }

            return inputData.toString();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
