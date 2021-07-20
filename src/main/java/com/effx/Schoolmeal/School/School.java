package com.effx.Schoolmeal.School;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class School {
    String orgCode;
    String kraOrgNm;
    String schulKndScCode;
    String schulCrseScCode;
}

class SchoolComparator implements Comparator<School> {
    @Override
    public int compare(School a, School b) {
        return a.getKraOrgNm().compareTo(b.getKraOrgNm());
    }
}
