package com.example.myperfectapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class AppControllerTest {

    @Test
    void testWithCounties() {
        List<StringBuilder> test = new ArrayList<>();
        test.add(new StringBuilder("Easter Monday: 2021-04-05 (LV), 2021-04-05 (GB-ENG, GB-WLS, GB-NIR)"));
        test.add(new StringBuilder("New Year's Day: 2021-01-01 (LV), 2021-01-01 (GB), 2021-01-04 (GB-SCT)"));
        test.add(new StringBuilder("St. Stephen's Day: 2021-12-26 (LV), 2021-12-28 (GB)"));
        test.add(new StringBuilder("Christmas Day: 2021-12-25 (LV), 2021-12-27 (GB)"));
        test.add(new StringBuilder("Good Friday: 2021-04-02 (LV), 2021-04-02 (GB)"));

        List<StringBuilder> result = new AppController().getCommonHolidays("lv", "gb", "2021");

        Assertions.assertEquals(test.toString(), result.toString());
    }

    @Test
    void testWithoutCounties() {
        List<StringBuilder> test = new ArrayList<>();
        test.add(new StringBuilder("Labour Day: 2021-05-01 (LV), 2021-05-01 (RU)"));
        test.add(new StringBuilder("New Year's Day: 2021-01-01 (LV), 2021-01-01 (RU)"));

        List<StringBuilder> result = new AppController().getCommonHolidays("lv", "ru", "2021");

        Assertions.assertEquals(test.toString(), result.toString());
    }

    @Test
    void testWithWrongURL() {
        try {
            new AppController().getCommonHolidays("uk","lv","2021");
        } catch (ResponseStatusException e) {
            Assertions.assertEquals(HttpStatusCode.valueOf(400), e.getStatusCode());
        }
    }

    @Test
    void testWithCorrectURL() {
        try {
            new AppController().getCommonHolidays("gb","lv","2021");
        } catch (ResponseStatusException e) {
            Assertions.assertEquals(HttpStatusCode.valueOf(200), e.getStatusCode());
        }
    }
}
