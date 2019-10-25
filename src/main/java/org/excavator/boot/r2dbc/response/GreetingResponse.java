package org.excavator.boot.r2dbc.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingResponse{
    private String message;
}
