package org.excavator.boot.r2dbc.controller;

import org.excavator.boot.r2dbc.request.GreetingRequest;
import org.excavator.boot.r2dbc.response.GreetingResponse;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class GreetingsController{
    @MessageMapping("intervals")
    Flux<GreetingResponse> interval(GreetingRequest request){
        return Flux.interval(Duration.ofMillis(1000))
            .map(interval ->new GreetingResponse("hello (#" + interval + " )" + request.getName() + "!"))
    }
}
