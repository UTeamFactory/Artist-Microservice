package com.example.artistmicroservice.command.application.validators;

import com.example.artistmicroservice.command.application.dtos.request.EditArtistRequest;
import com.example.artistmicroservice.command.domain.entities.Artist;
import com.example.artistmicroservice.command.infrastructure.ArtistRegistryRepository;
import com.example.artistmicroservice.common.application.Notification;
import org.axonframework.messaging.unitofwork.DefaultUnitOfWork;
import org.axonframework.messaging.unitofwork.UnitOfWork;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.axonframework.modelling.command.Repository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class EditArtistValidator {
    private final ArtistRegistryRepository artistRegistryRepository;
    private final Repository<Artist> artistRepository;
    public EditArtistValidator(ArtistRegistryRepository artistRegistryRepository, Repository<Artist> artistRepository) {
        this.artistRegistryRepository = artistRegistryRepository;
        this.artistRepository = artistRepository;
    }

    public Notification validate(EditArtistRequest editArtistRequest){
        Notification notification = new Notification();
        String artistId = editArtistRequest.getId().trim();
        if (artistId.isEmpty()) {
            notification.addError("Customer id is required");
        }
        loadArtistAggregate(artistId);

        String firstName = editArtistRequest.getFirstname().trim();
        if (firstName.isEmpty()) {
            notification.addError("Artist firstname is required");
        }
        String lastName = editArtistRequest.getLastname().trim();
        if (lastName.isEmpty()) {
            notification.addError("Artist lastname is required");
        }
        String alias = editArtistRequest.getAlias().trim();
        if (alias.isEmpty()) {
            notification.addError("Artist alias is required");
        }
        String description = editArtistRequest.getDescription().trim();
        if (description.isEmpty()) {
            notification.addError("Artist description is required");
        }
        String phrase = editArtistRequest.getPhrase().trim();
        if (phrase.isEmpty()) {
            notification.addError("Artist phrase is required");
        }

        if (notification.hasErrors()) {
            return notification;
        }

        return notification;
    }

    private void loadArtistAggregate(String artistId){
        UnitOfWork unitOfWork = null;
        try {
            unitOfWork = DefaultUnitOfWork.startAndGet(null);
            artistRepository.load(artistId);
            unitOfWork.commit();
        } catch (AggregateNotFoundException ex) {
            unitOfWork.commit();
            throw ex;
        } catch (Exception ex) {
            if (unitOfWork != null) unitOfWork.rollback();
        }
    }
}
