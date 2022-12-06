package com.example.myperfectapp;

import com.example.myperfectapp.dto.HolidayResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @Spy
    AppService appService;

    @Test
    void testWithCorrectInput() {
        String firstCountry = "LV";
        String secondCountry = "LT";
        String year = "2021";


        HolidayResponse[] firstHolidays = {
                new HolidayResponse("New Year's Day", LocalDate.of(2021,1,1)),
                new HolidayResponse("Good Friday", LocalDate.of(2021,4,2)),
                new HolidayResponse("Easter Monday", LocalDate.of(2021,4,5))};

        HolidayResponse[] secondHolidays = {
                new HolidayResponse("New Year's Day", LocalDate.of(2021,1,1)),
                new HolidayResponse("Bad Friday", LocalDate.of(2021,4,2)),
                new HolidayResponse("Easter Monday", LocalDate.of(2021,4,5))};

        Mockito.doAnswer(invocationOnMock ->  firstHolidays).when(appService).callAPI(firstCountry, year);
        Mockito.doAnswer(invocationOnMock ->  secondHolidays).when(appService).callAPI(secondCountry, year);

        List<String> expected = new ArrayList<>();
        expected.add("New Year's Day: 2021-01-01");
        expected.add("Easter Monday: 2021-04-05");

        List<String> result = appService.getCommonHolidays(firstCountry, secondCountry, year);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testWithIncorrectInput() {

        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class,
                () -> appService.getCommonHolidays("LV", "UK", "2021"));
        Assertions.assertEquals(400, exception.getRawStatusCode());

    }

}
