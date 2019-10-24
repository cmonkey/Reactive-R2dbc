package org.excavator.boot.r2dbc; 

public class RsocketClientApplication{
    
    @SneakyThrows
    public static void main (String [] args) {
        SpringApplication.run(RsocketClientApplication.class, args);

        Syste.in.read();
    }

    @Bean
    RSocketRequester rSocketRequester(RSocketRequester.Builder builder){
        return builder.connectTcp("localhost", 7777).block();
    }
}
