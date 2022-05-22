package com.example.artistmicroservice.command.application.handlers;

import com.example.artistmicroservice.contracts.events.ArtistEdited;
import com.example.artistmicroservice.contracts.events.ArtistRegistered;
import org.axonframework.eventhandling.EventHandler;

public class ArtistEventHandler {

    public  ArtistEventHandler(){}

    @EventHandler
    public void on(ArtistRegistered event){}

    @EventHandler
    public void on(ArtistEdited event){}

}
