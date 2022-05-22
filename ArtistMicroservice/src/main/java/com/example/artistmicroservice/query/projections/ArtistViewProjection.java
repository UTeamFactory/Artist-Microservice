package com.example.artistmicroservice.query.projections;

import com.example.artistmicroservice.contracts.events.*;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class ArtistViewProjection {
    private final ArtistViewRepository artistViewRepository;

    public ArtistViewProjection(ArtistViewRepository artistViewRepository){
        this.artistViewRepository = artistViewRepository;
    }

    @EventHandler
    public void on(ArtistRegistered event, @Timestamp Instant timestamp){
        ArtistView artistView = new ArtistView(event.getId(), event.getFirstname(), event.getLastname() ,event.getAlias(), event.getDescription(), event.getPhrase(), event.getImage(), event.getTwitterLink(), event.getInstagramLink(), event.getFacebookLink(), event.getOccurredOn());
        artistViewRepository.save(artistView);
    }

    @EventHandler
    public void on(ArtistEdited event, @Timestamp Instant timestamp){
        Optional<ArtistView> artistViewOptional = artistViewRepository.findById(event.getId().toString());
        if(artistViewOptional.isPresent()){
            ArtistView artistView = artistViewOptional.get();
            artistView.setFirstname(event.getFirstname());
            artistView.setLastname(event.getLastname());
            artistView.setAlias(event.getAlias());
            artistView.setDescription(event.getDescription());
            artistView.setPhrase(event.getPhrase());
            artistView.setImage(event.getImage());
            artistView.setFacebooklink(event.getFacebookLink());
            artistView.setTwitterlink(event.getTwitterLink());
            artistView.setInstagramlink(event.getInstagramLink());
            artistView.setUpdatedAt(event.getOcurredOn());
            artistViewRepository.save(artistView);
        }
    }
}
