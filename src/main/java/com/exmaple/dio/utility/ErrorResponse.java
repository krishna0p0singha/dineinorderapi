package com.exmaple.dio.utility;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String type;
    private int status;
    private String message;
}
