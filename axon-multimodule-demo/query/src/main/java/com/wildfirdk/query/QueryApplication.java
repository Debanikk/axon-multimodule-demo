package com.wildfirdk.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.wildfiredk.data.repository")
@EntityScan("com.wildfiredk.data, org.axonframework.eventhandling.tokenstore, org.axonframework.modelling.saga.repository.jpa, org.axonframework.eventsourcing.eventstore.jpa")
public class QueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class, args);
    }
}
