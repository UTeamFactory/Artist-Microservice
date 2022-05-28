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
import com.example.artistmicroservice.common.application.ResultType;
import com.example.artistmicroservice.contracts.commands.EditArtist;
import com.example.artistmicroservice.contracts.commands.RegisterArtist;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Component;

import java.awt.image.RescaleOp;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

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
        String artistId = UUID.randomUUID().toString();
        RegisterArtist registerArtist = new RegisterArtist(
                artistId,
                registerArtistRequest.getFirstname().trim(),
                registerArtistRequest.getLastname().trim(),
                registerArtistRequest.getAlias().trim(),
                registerArtistRequest.getDescription().trim(),
                registerArtistRequest.getPhrase().trim(),
                registerArtistRequest.getImage().trim(),
                registerArtistRequest.getInstagramLink().trim(),
                registerArtistRequest.getFacebookLink().trim(),
                registerArtistRequest.getTwitterLink().trim()
        );
        CompletableFuture<Object> future = commandGateway.send(registerArtist);
        CompletableFuture<ResultType> futureResult = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = futureResult.get();
        if (resultType == ResultType.FAILURE){
            throw new Exception();
        }
        RegisterArtistResponse registerArtistResponseDto = new RegisterArtistResponse(
                registerArtist.getId(),
                registerArtist.getFirstname(),
                registerArtist.getLastname(),
                registerArtist.getAlias(),
                registerArtist.getDescription(),
                registerArtist.getPhrase(),
                registerArtist.getImage(),
                registerArtist.getInstagramLink(),
                registerArtist.getFacebookLink(),
                registerArtist.getTwitterLink()
        );
        return Result.success(registerArtistResponseDto);
    }

    public Result<EditArtistResponse, Notification> edit(EditArtistRequest editArtistRequest) throws Exception {
        Notification notification = this.editArtistValidator.validate(editArtistRequest);
        if (notification.hasErrors()){
            return Result.failure(notification);
        }
        EditArtist editArtist = new EditArtist(
                editArtistRequest.getId().trim(),
                editArtistRequest.getFirstname().trim(),
                editArtistRequest.getLastname().trim(),
                editArtistRequest.getAlias().trim(),
                editArtistRequest.getDescription().trim(),
                editArtistRequest.getPhrase().trim(),
                editArtistRequest.getImage().trim(),
                editArtistRequest.getInstagramLink().trim(),
                editArtistRequest.getFacebookLink().trim(),
                editArtistRequest.getTwitterLink().trim()
        );
        CompletableFuture<Object> future = commandGateway.send(editArtist);
        CompletableFuture<ResultType> futureResult = future.handle((ok, ex) -> (ex != null) ? ResultType.FAILURE : ResultType.SUCCESS);
        ResultType resultType = futureResult.get();
        if (resultType == ResultType.FAILURE){
            throw new Exception();
        }
        EditArtistResponse editArtistResponse = new EditArtistResponse(
                editArtist.getId(),
                editArtist.getFirstname(),
                editArtist.getLastname(),
                editArtist.getAlias(),
                editArtist.getDescription(),
                editArtist.getPhrase(),
                editArtist.getImage(),
                editArtist.getInstagramLink(),
                editArtist.getFacebookLink(),
                editArtist.getTwitterLink()
        );
        return Result.success(editArtistResponse);
    }

}
