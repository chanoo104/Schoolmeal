package com.effx.Schoolmeal.School;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class School_DTO {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private HttpStatus status;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private int count;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private School[] schools;
}

