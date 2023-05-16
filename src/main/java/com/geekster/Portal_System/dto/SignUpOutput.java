package com.geekster.Portal_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpOutput {
    private String message;

    private HttpStatus statusCode;

}
