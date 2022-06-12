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
    /*@AggregateIdentifier
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "artist_id"))
    })
    private ArtistId artistId;*/
    @AggregateIdentifier
    private String artistId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "first_name", length = 100, nullable = false))
    })
    private Firstname firstName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "last_name", length = 100, nullable = false))
    })
    private Lastname lastName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "alias", length = 50, nullable = false))
    })
    private Alias alias;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "description", length = 200, nullable = false))
    })
    private Description description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "phrase", length = 150, nullable = false))
    })
    private Phrase phrase;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "image", length = 150, nullable = false))
    })
    private Image image;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "instagram_link", length = 150, nullable = false))
    })
    private Link instagramLink;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "facebook_link", length = 150, nullable = false))
    })
    private Link facebookLink;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "twitter_link", length = 150, nullable = false))
    })
    private Link twitterLink;

    public Artist(){}

    @CommandHandler
    public Artist(RegisterArtist command){
        Instant now = Instant.now();
        apply(
          new ArtistRegistered(
                  command.getArtistId(),
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
                        command.getArtistId(),
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
        artistId = event.getArtistId();
        firstName = new Firstname(event.getFirstName());
        lastName = new Lastname(event.getLastName());
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
        firstName = new Firstname(event.getFirstName());
        lastName = new Lastname(event.getLastName());
        alias = new Alias(event.getAlias());
        description = new Description(event.getDescription());
        phrase = new Phrase(event.getPhrase());
        image = new Image(event.getImage());
        twitterLink = new Link(event.getTwitterLink());
        facebookLink = new Link(event.getFacebookLink());
        instagramLink = new Link(event.getInstagramLink());
    }

}
