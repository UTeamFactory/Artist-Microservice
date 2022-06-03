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
import java.util.UUID;

@Aggregate
public class Artist {
    @AggregateIdentifier
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private String id;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "username", length = 30, nullable = false))
    })
    private Username username;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "password", length = 75, nullable = false))
    })
    private Password password;

    @AggregateIdentifier
    @Embedded
    private AuditTrail auditTrail;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "firstname", length = 75, nullable = false))
    })
    private Firstname firstname;


    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "lastname", length = 75, nullable = false))
    })
    private Lastname lastname;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "alias", length = 75, nullable = false))
    })
    private Alias alias;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "description", length = 200, nullable = false))
    })
    private Description description;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "phrase", length = 200, nullable = false))
    })
    private Phrase phrase;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "image", nullable = false))
    })
    private Image image;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "instagram_link", nullable = true))
    })
    private Link instagramLink;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "facebook_link", nullable = true))
    })
    private Link facebookLink;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "twitter_link", nullable = true))
    })
    private Link twitterLink;

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
        id = UUID.randomUUID().toString();
        firstname = new Firstname(event.getFirstname());
        lastname = new Lastname(event.getLastname());
        alias = new Alias(event.getAlias());
        description = new Description(event.getDescription());
        phrase = new Phrase(event.getPhrase());
        image = new Image(event.getImage());
        twitterLink = new Link(event.getTwitterLink());
        facebookLink = new Link(event.getFacebookLink());
        instagramLink = new Link(event.getInstagramLink());

    }

    @EventSourcingHandler
    protected void on (ArtistEdited event){
        firstname = new Firstname(event.getFirstname());
        lastname = new Lastname(event.getLastname());
        alias = new Alias(event.getAlias());
        description = new Description(event.getDescription());
        phrase = new Phrase(event.getPhrase());
        image = new Image(event.getImage());
        twitterLink = new Link(event.getTwitterLink());
        facebookLink = new Link(event.getFacebookLink());
        instagramLink = new Link(event.getInstagramLink());
    }

}
