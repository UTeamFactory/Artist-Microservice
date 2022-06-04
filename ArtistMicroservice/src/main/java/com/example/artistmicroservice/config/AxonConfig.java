package com.example.artistmicroservice.config;

import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.artistmicroservice.command.domain.entities.Artist;

@Configuration
public class AxonConfig {
    @Bean
    public Repository<Artist> eventSourcingRepository(EventStore eventStore) {
        return EventSourcingRepository.builder(Artist.class)
                .eventStore(eventStore)
                .build();
    }

}
