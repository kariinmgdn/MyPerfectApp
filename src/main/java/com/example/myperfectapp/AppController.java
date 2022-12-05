package com.example.myperfectapp;

<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
>>>>>>> 250cd76 (Changed app structure)
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> fc56d38 (added swagger)

import java.util.List;

@RestController
public class AppController {

    private final AppService appService;
<<<<<<< HEAD

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/myperfectapp/{first}/{second}/{year}")
    public List<String> getCommonHolidays(@PathVariable String first,
                                          @PathVariable String second,
                                          @PathVariable String year) {

=======

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/myperfectapp/{first}/{second}/{year}")
    public List<String> getCommonHolidays(@PathVariable String first,
                                          @PathVariable String second,
                                          @PathVariable String year) {

>>>>>>> 250cd76 (Changed app structure)
        return appService.getCommonHolidays(first, second, year);
    }
}
