package com.example.webflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TestClass {

  public void testMono(){
        Mono<?> monoString  = Mono.just("EnggAdda").
                then(Mono.error(new RuntimeException("Runtime exception occured")))
                .log();
        monoString.subscribe(System.out::println);}

    public void testFlux(){
        Flux<String> fluxString  = Flux.just("EnggAdda","Youtube","Spring Boot" ,"Java")
                .concatWithValues("Hello").log();
        fluxString.subscribe(System.out::println);}

    public static void main(String[] args) {
        TestClass testClass  = new TestClass();
        testClass.testMono();
        testClass.testFlux();


    }
}
