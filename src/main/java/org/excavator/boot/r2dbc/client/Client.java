package org.excavator.boot.r2dbc.client;

import lombok.RequiredArgsConstructor;
import org.excavator.boot.r2dbc.request.GreetingRequest;
import org.excavator.boot.r2dbc.response.GreetingResponse;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Client{
    private final RSocketRequester rSocketRequester ;

    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    @EventListener(ApplicationReadyEvent.class)
    public void ready(){
        this.rSocketRequester.route("intervals")
            .data(new GreetingRequest("World"))
            .retrieveFlux(GreetingResponse.class)
            .subscribe(im -> logger.info("consuming  = [{}]", im.getMessage());
    }
}

