package org.excavator.boot.r2dbc.controller;

@Controller
public class GreetingsController{
    @MessageMapping("intervals")
    Flux<GreetingResponse> interval(GreetingRequest request){
        return Flux.interval(Duration.ofMillis(1000))
            .map(interval ->new GreetingResponse("hello (#" + interval + " )" + request.getName() + "!"))
    }
}
