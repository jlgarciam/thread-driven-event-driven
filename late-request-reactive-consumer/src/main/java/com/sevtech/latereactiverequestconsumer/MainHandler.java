package com.sevtech.latereactiverequestconsumer;

import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Component
public class MainHandler {

    @Autowired
    WebClient webClient;

    @Value("${endpoint}")
    String endpoint;

    public Mono<ServerResponse> makeRequest(ServerRequest request){
        System.out.println("Reactive Request");
        return webClient.get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(result -> ServerResponse.ok().body(BodyInserters.fromValue("Spring Reactive: " + result)) );
    }

    public Mono<ServerResponse> ssEvent(ServerRequest request) {
        Flux<ServerSentEvent<String>> result =
                Flux.interval(Duration.ofSeconds(5))
                .map( x -> ServerSentEvent
                        .builder("Server Sent Events")
                        .id(x.toString())
                        .comment("comment")
                        .build()
                );

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(BodyInserters.fromServerSentEvents(result));
    }
}
