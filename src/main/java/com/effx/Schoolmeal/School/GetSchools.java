package com.effx.Schoolmeal.School;

import com.effx.Schoolmeal.Meal.JsoupParser;
import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class GetSchools {
    public School[] getSchools(String region, String query) {
        try {
            Document document = Jsoup.connect("https://par." + region + ".go.kr/spr_ccm_cm01_100.do")
                    .data("kraOrgNm", query)
                    .ignoreContentType(true)
                    .post();
            Gson gson = new Gson();
            JsoupParser jsoupParser = new JsoupParser();
            JsonArray array = JsonParser.parseString(document.text()).getAsJsonObject().get("resultSVO").getAsJsonObject().get("data").getAsJsonObject().get("orgDVOList").getAsJsonArray();
            ArrayList<School> schools = new ArrayList<>();
            if (array.size() < 5) {
                for (JsonElement jsonElement : array) {
                    JsonObject tmp = jsonElement.getAsJsonObject();
                    schools.add(new School(tmp.get("orgCode").toString().replaceAll("\"", ""),
                            tmp.get("kraOrgNm").toString().replaceAll("\"", ""),
                            tmp.get("schulKndScCode").toString().replaceAll("\"", ""),
                            tmp.get("schulCrseScCode").toString().replaceAll("\"", "")));
                }
            } else {
                for (int i = 0; i < 5; i++) {
                    JsonObject tmp = array.get(i).getAsJsonObject();
                    schools.add(new School(tmp.get("orgCode").toString().replaceAll("\"", ""),
                            tmp.get("kraOrgNm").toString().replaceAll("\"", ""),
                            tmp.get("schulKndScCode").toString().replaceAll("\"", ""),
                            tmp.get("schulCrseScCode").toString().replaceAll("\"", "")));
                }
            }
            schools.sort(new SchoolComparator());
            return schools.toArray(new School[schools.size()]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
