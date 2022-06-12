package com.example.artistmicroservice.query.projections;

import com.example.artistmicroservice.contracts.events.ArtistEdited;
import com.example.artistmicroservice.contracts.events.ArtistRegistered;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class ArtistHistoryViewProjection {

    private final ArtistHistoryViewRepository artistHistoryViewRepository;

    public ArtistHistoryViewProjection(ArtistHistoryViewRepository artistHistoryViewRepository) {
        this.artistHistoryViewRepository = artistHistoryViewRepository;
    }

    @EventHandler
    public void on(ArtistRegistered event, @Timestamp Instant timestamp){
        ArtistHistoryView artistHistoryView = new ArtistHistoryView(event.getArtistId(), event.getFirstName(), event.getLastName(), event.getAlias(), event.getDescription(), event.getPhrase(), event.getImage(), event.getInstagramLink(), event.getFacebookLink(), event.getTwitterLink(), event.getOccurredOn());
        artistHistoryViewRepository.save(artistHistoryView);
    }

    @EventHandler
    public void on(ArtistEdited event, @Timestamp Instant timestamp){
        Optional<ArtistHistoryView> artistHistoryViewOptional = artistHistoryViewRepository.getLastByArtistId(event.getArtistId().toString());
        if(artistHistoryViewOptional.isPresent()){
            ArtistHistoryView artistHistoryView = artistHistoryViewOptional.get();
            artistHistoryView = new ArtistHistoryView(artistHistoryView);

            artistHistoryView.setFirstName(event.getFirstName());
            artistHistoryView.setLastName(event.getLastName());
            artistHistoryView.setAlias(event.getAlias());
            artistHistoryView.setDescription(event.getDescription());
            artistHistoryView.setPhrase(event.getPhrase());
            artistHistoryView.setImage(event.getImage());
            artistHistoryView.setInstagramLink(event.getInstagramLink());
            artistHistoryView.setTwitterLink(event.getTwitterLink());
            artistHistoryView.setFacebookLink(event.getFacebookLink());
            artistHistoryView.setCreatedAt(event.getOccurredOn());

            artistHistoryViewRepository.save(artistHistoryView);
        }
    }
}
