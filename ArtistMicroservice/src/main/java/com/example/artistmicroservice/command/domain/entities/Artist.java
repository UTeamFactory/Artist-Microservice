package com.example.artistmicroservice.command.domain.entities;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import com.example.artistmicroservice.command.domain.values.*;
import com.example.artistmicroservice.contracts.commands.EditArtist;
import com.example.artistmicroservice.contracts.commands.RegisterArtist;
import com.example.artistmicroservice.contracts.events.ArtistEdited;
import com.example.artistmicroservice.contracts.events.ArtistRegistered;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import javax.persistence.*;
import java.time.Instant;

@Aggregate
public class Artist {

    @AggregateIdentifier
    private String id;

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String alias;
    private String description;
    private String phrase;
    private String image;
    private String instagramLink;
    private String facebookLink;
    private String twitterLink;

    public Artist(){}

    /*public Artist(UserId id, Username username, Password password, AuditTrail auditTrail, Firstname firstname, Lastname lastname, Alias alias, Description description, Phrase phrase, Image image, Link instagramLink, Link facebookLink, Link twitterLink) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setFirstname(firstname);
        setLastname(lastname);
        setAuditTrail(auditTrail);
        setAlias(alias);
        setDescription(description);
        setPhrase(phrase);
        setImage(image);
        setInstagramLink(instagramLink);
        setFacebookLink(facebookLink);
        setTwitterLink(twitterLink);
    }*/

    @CommandHandler
    public Artist(RegisterArtist command){
        Instant now = Instant.now();
        apply(
          new ArtistRegistered(
                  command.getId(),
                  command.getFirstname(),
                  command.getLastname(),
                  command.getAlias(),
                  command.getDescription(),
                  command.getPhrase(),
                  command.getImage(),
                  command.getInstagramLink(),
                  command.getFacebookLink(),
                  command.getTwitterLink(),
                  now
          )
        );
    }

    @CommandHandler
    public void handle(EditArtist command){
        Instant now = Instant.now();
        apply(
                new ArtistEdited(
                        command.getId(),
                        command.getFirstname(),
                        command.getLastname(),
                        command.getAlias(),
                        command.getDescription(),
                        command.getPhrase(),
                        command.getImage(),
                        command.getInstagramLink(),
                        command.getFacebookLink(),
                        command.getTwitterLink(),
                        now
                )
        );
    }

    @EventSourcingHandler
    protected void on (ArtistRegistered event){
        id = event.getId();
        firstname = event.getFirstname();
        lastname = event.getLastname();
        alias = event.getAlias();
        description = event.getDescription();
        phrase = event.getPhrase();
        image = event.getImage();
        twitterLink = event.getTwitterLink();
        facebookLink = event.getFacebookLink();
        instagramLink = event.getInstagramLink();

    }

    @EventSourcingHandler
    protected void on (ArtistEdited event){
        firstname = event.getFirstname();
        lastname = event.getLastname();
        alias = event.getAlias();
        description = event.getDescription();
        phrase = event.getPhrase();
        image = event.getImage();
        twitterLink = event.getTwitterLink();
        facebookLink = event.getFacebookLink();
        instagramLink = event.getInstagramLink();
    }

}
