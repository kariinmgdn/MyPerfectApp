package com.example.myperfectapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/myperfectapp/{first}/{second}/{year}")
    public List<String> getCommonHolidays(@PathVariable String first,
                                          @PathVariable String second,
                                          @PathVariable String year) {

        return appService.getCommonHolidays(first, second, year);
    }
}
