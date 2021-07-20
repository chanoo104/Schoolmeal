package com.effx.Schoolmeal.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JsoupParser {

    public String[] getMeal(String schulCode, String schulCrseScCode, String schulKndScCode, String schMmealScCode, String schYmd) {
        try {
            String url = "http://stu.ice.go.kr/sts_sci_md01_001.do" +
                    "?schulCode=" + schulCode +
                    "&schulCrseScCode=" + schulCrseScCode +
                    "&schulKndScCode=" + schulKndScCode +
                    "&schMmealScCode=" + schMmealScCode +
                    "&schYmd=" + schYmd;

            Document doc = Jsoup.connect(url).get();
            System.out.println(url);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            Date date = dateFormat.parse(schYmd);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayNum = cal.get(Calendar.DAY_OF_WEEK) + 1;
            Elements today_meal_html = doc.select("table > tbody > tr:nth-child(2) > td:nth-child(" + dayNum + ")");
            return today_meal_html.html().replaceAll("<br>", "\n").split("\n");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
}
