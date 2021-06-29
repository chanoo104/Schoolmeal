package com.effx.springtest2.Meal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor                   // this.var = var; 와 같은 생성자를 자동으로 생성한다.
@Getter                               // getId(), getContent() 등의 Getter를 자동으로 생성한다.
@Setter                               // setId(id), setContent(content) 등의 Setter를 자동으로 생성한다.
public class Meal_DTO {
    private String schulCode; // 학교 교유 코드
    private String schulKndScCode; // 학교 구분 코드
    private String schulCrseScCode; // 학교 구분 코드
    private String schMmealScCode; // 급식 구분
    private String schYmd; // 날짜
}
