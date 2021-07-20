package com.effx.Schoolmeal.Meal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor                   // this.var = var; 와 같은 생성자를 자동으로 생성한다.
@Getter                               // getId(), getContent() 등의 Getter를 자동으로 생성한다.
@Setter                               // setId(id), setContent(content) 등의 Setter를 자동으로 생성한다.
public class Meal_DTO {
    private String[] meals;
    private HttpStatus status;

    public Meal_DTO() {
    }
}
