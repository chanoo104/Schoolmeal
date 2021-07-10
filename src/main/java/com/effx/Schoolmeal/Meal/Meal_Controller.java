package com.effx.Schoolmeal.Meal;

import com.effx.Schoolmeal.Parser.JsoupParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class Meal_Controller {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/meal", produces = "application/json")
    public String[] meal(@RequestParam(value = "schulCode") String schulCode,
                         @RequestParam(value = "schulKndScCode") String schulKndScCode,
                         @RequestParam(value = "schulCrseScCode") String schulCrseScCode,
                         @RequestParam(value = "schMmealScCode") String schMmealScCode,
                         @RequestParam(value = "schYmd") String schYmd) {
        JsoupParser jp = new JsoupParser();
        return jp.getMeal(schulCode, schulKndScCode, schulCrseScCode, schMmealScCode, schYmd);
    }
}
