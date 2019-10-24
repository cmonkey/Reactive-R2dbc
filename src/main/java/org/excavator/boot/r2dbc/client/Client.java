package org.excavator.boot.r2dbc.client;

@Component
@RequiredArgsConstructor
public class Client{
    private final RSocketRequester rSocketRequester ;

    @EventListener(ApplicationReadyEvent.class)
    public void ready(){
        this.rSocketRequester.route("intervals")
            .data(new GreetingRequest("World"))
            .retrieveFlux(GreetingResponse.class)
            .subscribe(im -> logger.info("consuming  = [{}]", im.getMessage());
    }
}

