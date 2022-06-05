package com.example.artistmicroservice.command.application.handlers;

import com.example.artistmicroservice.command.infrastructure.ArtistRegistry;
import com.example.artistmicroservice.command.infrastructure.ArtistRegistryRepository;
import com.example.artistmicroservice.contracts.events.ArtistEdited;
import com.example.artistmicroservice.contracts.events.ArtistRegistered;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ProcessingGroup("artistRegistry")
public class ArtistEventHandler {
    private final ArtistRegistryRepository artistRegistryRepository;

    public ArtistEventHandler(ArtistRegistryRepository artistRegistryRepository){
        this.artistRegistryRepository = artistRegistryRepository;
    }

    @EventHandler
    public void on(ArtistRegistered event){
        artistRegistryRepository.save(new ArtistRegistry(
                event.getArtistId(),
                event.getFirstName(),
                event.getLastName(),
                event.getAlias(),
                event.getDescription(),
                event.getPhrase(),
                event.getImage(),
                event.getInstagramLink(),
                event.getFacebookLink(),
                event.getTwitterLink()
        ));
    }

    @EventHandler
    public void on(ArtistEdited event){
        Optional<ArtistRegistry> ArtistRegistryOptional = artistRegistryRepository.getByArtistId(event.getArtistId());
        ArtistRegistryOptional.ifPresent(artistRegistryRepository::delete);
        artistRegistryRepository.save(new ArtistRegistry(
                event.getArtistId(),
                event.getFirstName(),
                event.getLastName(),
                event.getAlias(),
                event.getDescription(),
                event.getPhrase(),
                event.getImage(),
                event.getInstagramLink(),
                event.getFacebookLink(),
                event.getTwitterLink()
        ));
    }

}
