package com.geekster.Portal_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
public class SignInOutput {

    @Nullable
    private String message;

    @NonNull
    private String token;

}
