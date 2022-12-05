package com.example.myperfectapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AppControllerTest {

    @Mock
    AppService appService;

    @InjectMocks
    AppController appController;

    @Test
    void testGetCommonHolidays() {

        List<String> test = new ArrayList<>();
        test.add("New Year's Day: 2021-01-01");
        test.add("Easter Sunday: 2021-04-04");
        test.add("Easter Monday: 2021-04-05");
        test.add("Christmas Eve: 2021-12-24");
        test.add("Christmas Day: 2021-12-25");
        test.add("St. Stephen's Day: 2021-12-26");

        Mockito.doAnswer(invocationOnMock -> test)
                .when(appService)
                .getCommonHolidays("lv", "lt", "2021");

        List<String> result = appController.getCommonHolidays("lv", "lt", "2021");

        Assertions.assertEquals(test, result);
    }
}
