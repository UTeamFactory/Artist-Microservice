package com.example.artistmicroservice.command.application.services;

import com.example.artistmicroservice.command.application.dtos.request.EditArtistRequest;
import com.example.artistmicroservice.command.application.dtos.request.RegisterArtistRequest;
import com.example.artistmicroservice.command.application.dtos.response.EditArtistResponse;
import com.example.artistmicroservice.command.application.dtos.response.RegisterArtistResponse;
import com.example.artistmicroservice.command.application.validators.EditArtistValidator;
import com.example.artistmicroservice.command.application.validators.RegisterArtistValidator;
import com.example.artistmicroservice.command.infrastructure.ArtistRegistryRepository;
import com.example.artistmicroservice.common.application.Notification;
import com.example.artistmicroservice.common.application.Result;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

@Component
public class ArtistApplicationService {
    private final RegisterArtistValidator registerArtistValidator;
    private final EditArtistValidator editArtistValidator;
    protected final CommandGateway commandGateway;
    private final ArtistRegistryRepository artistRegistryRepository;

    public ArtistApplicationService(RegisterArtistValidator registerArtistValidator, EditArtistValidator editArtistValidator, CommandGateway commandGateway, ArtistRegistryRepository artistRegistryRepository) {
        this.registerArtistValidator = registerArtistValidator;
        this.editArtistValidator = editArtistValidator;
        this.commandGateway = commandGateway;
        this.artistRegistryRepository = artistRegistryRepository;
    }

    public Result<RegisterArtistResponse, Notification> register(RegisterArtistRequest registerArtistRequest) throws Exception {
        Notification notification = this.registerArtistValidator.validate(registerArtistRequest);
        if (notification.hasErrors()){
            return Result.failure(notification);
        }


        return Result.failure(notification);
    }

    public Result<EditArtistResponse, Notification> register(EditArtistRequest editArtistRequest) throws Exception {
        Notification notification = this.editArtistValidator.validate(editArtistRequest);
        if (notification.hasErrors()){
            return Result.failure(notification);
        }


        return Result.failure(notification);
    }

}
