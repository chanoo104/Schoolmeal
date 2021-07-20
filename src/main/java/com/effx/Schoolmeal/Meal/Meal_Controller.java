package com.effx.Schoolmeal.Meal;

import com.effx.Schoolmeal.ErrorResponse;
import com.effx.Schoolmeal.Parser.JsoupParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class Meal_Controller {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/meal", produces = "application/json")
    public Meal_DTO meal(@RequestParam(value = "schulCode") String schulCode,
                         @RequestParam(value = "schulKndScCode") String schulKndScCode,
                         @RequestParam(value = "schulCrseScCode") String schulCrseScCode,
                         @RequestParam(value = "schMmealScCode") String schMmealScCode,
                         @RequestParam(value = "schYmd") String schYmd) {
        JsoupParser jp = new JsoupParser();
        Meal_DTO meal_dto = new Meal_DTO();
        String[] meals = jp.getMeal(schulCode, schulKndScCode, schulCrseScCode, schMmealScCode, schYmd);
        if (!meals[0].equals("")) {
            meal_dto.setMeals(meals);
            meal_dto.setStatus(HttpStatus.OK);
        } else {
            meal_dto.setStatus(HttpStatus.BAD_REQUEST);
        }

        return meal_dto;
    }
}
