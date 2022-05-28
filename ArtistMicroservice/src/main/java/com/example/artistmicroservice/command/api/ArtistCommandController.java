package com.example.artistmicroservice.command.api;

import com.example.artistmicroservice.command.application.dtos.request.EditArtistRequest;
import com.example.artistmicroservice.command.application.dtos.request.RegisterArtistRequest;
import com.example.artistmicroservice.command.application.dtos.response.EditArtistResponse;
import com.example.artistmicroservice.command.application.dtos.response.RegisterArtistResponse;
import com.example.artistmicroservice.command.application.services.ArtistApplicationService;
import com.example.artistmicroservice.command.infrastructure.ArtistRegistryRepository;
import com.example.artistmicroservice.common.api.ApiController;
import com.example.artistmicroservice.common.application.Notification;
import com.example.artistmicroservice.common.application.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
@Tag(name = "Artists")
public class ArtistCommandController {
    private final ArtistApplicationService artistApplicationService;
    private final CommandGateway commandGateway;
    private final ArtistRegistryRepository artistRegistryRepository;

    public ArtistCommandController(ArtistApplicationService artistApplicationService, CommandGateway commandGateway, ArtistRegistryRepository artistRegistryRepository) {
        this.artistApplicationService = artistApplicationService;
        this.commandGateway = commandGateway;
        this.artistRegistryRepository = artistRegistryRepository;
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> register(@RequestBody RegisterArtistRequest registerArtistRequest){
        try {
            Result<RegisterArtistResponse, Notification> result = artistApplicationService.register(registerArtistRequest);
            if (result.isSuccess()){
                return ApiController.created(result.getSuccess());
            }
            return ApiController.error(result.getFailure().getErrors());
        } catch (Exception e){
            return ApiController.serverError();
        }
    }

    @PutMapping("/{artistId}")
    public ResponseEntity<Object> edit(@PathVariable("artistId") String artistId, @RequestBody EditArtistRequest editArtistRequest){
        try {
            editArtistRequest.setId(artistId);
            Result<EditArtistResponse, Notification> result = artistApplicationService.edit(editArtistRequest);
            if (result.isSuccess()){
                return ApiController.ok(result.getSuccess());
            }
            return ApiController.error(result.getFailure().getErrors());
        } catch (AggregateNotFoundException exception){
            return ApiController.notFound();
        } catch (Exception e){
            return ApiController.serverError();
        }
    }

}
