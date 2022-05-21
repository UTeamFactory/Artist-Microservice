package command.application.handlers;

import contracts.events.ArtistEdited;
import contracts.events.ArtistRegistered;
import org.axonframework.eventhandling.EventHandler;

public class ArtistEventHandler {

    public  ArtistEventHandler(){}

    @EventHandler
    public void on(ArtistRegistered event){}

    @EventHandler
    public void on(ArtistEdited event){}

}
