package com.example.artistmicroservice.command.application.validators;

import com.example.artistmicroservice.command.application.dtos.request.RegisterArtistRequest;
import com.example.artistmicroservice.command.infrastructure.ArtistRegistryRepository;
import com.example.artistmicroservice.common.application.Notification;
import org.springframework.stereotype.Component;

@Component
public class RegisterArtistValidator {
    private final ArtistRegistryRepository artistRegistryRepository;
    public RegisterArtistValidator(ArtistRegistryRepository artistRegistryRepository) {
        this.artistRegistryRepository = artistRegistryRepository;
    }

    public Notification validate(RegisterArtistRequest registerArtistRequest) {
        Notification notification = new Notification();

        String firstName = registerArtistRequest.getFirstname().trim();
        if (firstName.isEmpty()) {
            notification.addError("Artist firstname is required");
        }
        String lastName = registerArtistRequest.getLastname().trim();
        if (lastName.isEmpty()) {
            notification.addError("Artist lastname is required");
        }
        String alias = registerArtistRequest.getAlias().trim();
        if (alias.isEmpty()) {
            notification.addError("Artist alias is required");
        }
        String description = registerArtistRequest.getDescription().trim();
        if (description.isEmpty()) {
            notification.addError("Artist description is required");
        }
        String phrase = registerArtistRequest.getPhrase().trim();
        if (phrase.isEmpty()) {
            notification.addError("Artist phrase is required");
        }

        if (notification.hasErrors()) {
            return notification;
        }
        return notification;
    }
}
