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
        ArtistView artistView = new ArtistView(event.getArtistId(), event.getFirstName(), event.getLastName() ,event.getAlias(), event.getDescription(), event.getPhrase(), event.getImage(), event.getTwitterLink(), event.getInstagramLink(), event.getFacebookLink(), event.getOccurredOn());
        artistViewRepository.save(artistView);
    }

    @EventHandler
    public void on(ArtistEdited event, @Timestamp Instant timestamp){
        Optional<ArtistView> artistViewOptional = artistViewRepository.findById(event.getArtistId().toString());
        if(artistViewOptional.isPresent()){
            ArtistView artistView = artistViewOptional.get();
            artistView.setFirstName(event.getFirstName());
            artistView.setLastName(event.getLastName());
            artistView.setAlias(event.getAlias());
            artistView.setDescription(event.getDescription());
            artistView.setPhrase(event.getPhrase());
            artistView.setImage(event.getImage());
            artistView.setFacebookLink(event.getFacebookLink());
            artistView.setTwitterLink(event.getTwitterLink());
            artistView.setInstagramLink(event.getInstagramLink());
            artistView.setUpdatedAt(event.getOccurredOn());
            artistViewRepository.save(artistView);
        }
    }
}
