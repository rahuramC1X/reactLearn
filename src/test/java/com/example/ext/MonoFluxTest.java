package com.example.ext;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
public class MonoFluxTest {

    @Test
    public void testMono() {
        Mono<Object> monoString = Mono.just("javaReactor")
                .then(Mono.error(new RuntimeException("Exception occurred")))
                .log();
        monoString.subscribe(System.out::println, (e)->System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occurred in Flux")))
                .concatWithValues("Rahuram")
                .log();

        fluxString.subscribe(System.out::println);
    }
}
