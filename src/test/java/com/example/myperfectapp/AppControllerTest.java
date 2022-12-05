package com.example.myperfectapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
<<<<<<< HEAD
<<<<<<< HEAD
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
=======
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
>>>>>>> 250cd76 (Changed app structure)
=======
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
>>>>>>> b553233 (changed service class)

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AppControllerTest {

<<<<<<< HEAD
<<<<<<< HEAD
    @Mock
    AppService appService;

    @InjectMocks
    AppController appController;
=======
    @Spy
=======
    @Mock
>>>>>>> b553233 (changed service class)
    AppService appService;

    @InjectMocks
    AppController appController;

    @Test
<<<<<<< HEAD
    void testCallAPI() {

        String firstCountry = "LV";
        String year = "2021";

        HolidayResponse[] firstTest = {new HolidayResponse("New Year's Day", LocalDate.of(2021,1,1)),
                new HolidayResponse("Good Friday", LocalDate.of(2021,4,2)),
                new HolidayResponse("Easter Monday", LocalDate.of(2021,4,5))};

        Mockito.doAnswer(invocationOnMock -> firstTest).when(appService).callAPI(firstCountry, year);
        HolidayResponse[] result = appService.callAPI(firstCountry, year);
                Assertions.assertEquals(firstTest, result);
    }
>>>>>>> 250cd76 (Changed app structure)

    @Test
=======
>>>>>>> 53be384 (added correct tests)
    void testGetCommonHolidays() {

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b553233 (changed service class)
        List<String> test = new ArrayList<>();
        test.add("New Year's Day: 2021-01-01");
        test.add("Easter Sunday: 2021-04-04");
        test.add("Easter Monday: 2021-04-05");
        test.add("Christmas Eve: 2021-12-24");
        test.add("Christmas Day: 2021-12-25");
        test.add("St. Stephen's Day: 2021-12-26");
<<<<<<< HEAD
=======
        List<StringBuilder> result = new AppController(appService).getCommonHolidays("lv", "ru", "2021");
>>>>>>> 250cd76 (Changed app structure)
=======
>>>>>>> b553233 (changed service class)

        Mockito.doAnswer(invocationOnMock -> test)
                .when(appService)
                .getCommonHolidays("lv", "lt", "2021");

<<<<<<< HEAD
<<<<<<< HEAD
        List<String> result = appController.getCommonHolidays("lv", "lt", "2021");

        Assertions.assertEquals(test, result);
=======
    @Test
    void testWithWrongURL() {
        try {
            new AppController(appService).getCommonHolidays("uk","lv","2021");
        } catch (ResponseStatusException e) {
            Assertions.assertEquals(HttpStatus.valueOf(400), e.getStatus());
        }
    }

    @Test
    void testWithCorrectURL() {
        try {
            new AppController(appService).getCommonHolidays("gb","lv","2021");
        } catch (ResponseStatusException e) {
            Assertions.assertEquals(HttpStatus.valueOf(200), e.getStatus());
        }
>>>>>>> 250cd76 (Changed app structure)
=======
        List<String> result = appController.getCommonHolidays("lv", "lt", "2021");

        Assertions.assertEquals(test, result);
>>>>>>> b553233 (changed service class)
    }
}
