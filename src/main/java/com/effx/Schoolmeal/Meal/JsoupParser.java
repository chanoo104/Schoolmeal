package com.effx.Schoolmeal.Meal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JsoupParser {

    public String[] getMeal(String region, String schulCode, String schulCrseScCode, String schulKndScCode, String schMmealScCode, String schYmd) {
        try {
            String url = "http://stu." + region + ".go.kr/sts_sci_md01_001.do" +
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
            return toTEXT(today_meal_html.html()).split("\n");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    public String toTEXT(String str) {
        if (str == null)
            return null;
        String returnStr = str;
        returnStr = returnStr.replaceAll("<br>", "\n");
        returnStr = returnStr.replaceAll("&gt;", ">");
        returnStr = returnStr.replaceAll("&lt;", "<");
        returnStr = returnStr.replaceAll("&quot;", "\"");
        returnStr = returnStr.replaceAll("&nbsp;", " ");
        returnStr = returnStr.replaceAll("&amp;", "&");
        returnStr = returnStr.replaceAll("\"", "");
        return returnStr;
    }


}
