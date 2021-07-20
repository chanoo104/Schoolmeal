package com.effx.Schoolmeal.School;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class School_Controller {
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/school", produces = "application/json")
    public School_DTO School_DTO(@RequestParam(value = "query") String query,
                                 @RequestParam(value = "region") String region) {
        GetSchools getSchools = new GetSchools();
        School[] schools = getSchools.getSchools(region, query);

        return new School_DTO(HttpStatus.OK, schools.length, schools);
    }
}
