package com.effx.Schoolmeal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor                   // this.var = var; 와 같은 생성자를 자동으로 생성한다.
@Getter                               // getId(), getContent() 등의 Getter를 자동으로 생성한다.
@Setter                               // setId(id), setContent(content) 등의 Setter를 자동으로 생성한다.
public class DTO {
    private long id;                  // 방문 ID
    private String content;           // 인삿말
}
