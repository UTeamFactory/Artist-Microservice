package com.example.artistmicroservice.query.projections;

import com.example.artistmicroservice.contracts.events.ArtistEdited;
import com.example.artistmicroservice.contracts.events.ArtistRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class ArtistHistoryViewProyection {

    private final ArtistHistoryViewRepository artistHistoryViewRepository;

    public ArtistHistoryViewProyection(ArtistHistoryViewRepository artistHistoryViewRepository) {
        this.artistHistoryViewRepository = artistHistoryViewRepository;
    }

    @EventHandler
    public void on(ArtistRegistered event, @Timestamp Instant timestamp){
        ArtistHistoryView artistHistoryView = new ArtistHistoryView(event.getId(), event.getFirstname(), event.getLastname(), event.getAlias(), event.getDescription(), event.getPhrase(), event.getImage(), event.getInstagramLink(), event.getTwitterLink(), event.getFacebookLink());
        artistHistoryViewRepository.save(artistHistoryView);
    }

    @EventHandler
    public void on(ArtistEdited event, @Timestamp Instant timestamp){
        Optional<ArtistHistoryView> artistHistoryViewOptional = artistHistoryViewRepository.getLastByUserId(event.getId().toString());
        if(artistHistoryViewOptional.isPresent()){
            ArtistHistoryView artistHistoryView = artistHistoryViewOptional.get();
            artistHistoryView = new ArtistHistoryView(artistHistoryView);
            artistHistoryView.setFirstname(event.getFirstname());
            artistHistoryView.setLastname(event.getLastname());
            artistHistoryView.setAlias(event.getAlias());
            artistHistoryView.setDescription(event.getDescription());
            artistHistoryView.setPhrase(event.getPhrase());
            artistHistoryView.setImage(event.getImage());
            artistHistoryView.setInstagramlink(event.getInstagramLink());
            artistHistoryView.setTwitterlink(event.getTwitterLink());
            artistHistoryView.setFacebooklink(event.getFacebookLink());
            artistHistoryViewRepository.save(artistHistoryView);
        }
    }
}
