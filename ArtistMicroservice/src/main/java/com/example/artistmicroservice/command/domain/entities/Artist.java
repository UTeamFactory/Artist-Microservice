package com.example.artistmicroservice.command.domain.entities;

import com.example.artistmicroservice.command.domain.values.*;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import javax.persistence.*;

@Entity(name = "Artist")
@Table(name = "artists")
@Data
@Aggregate
public class Artist {

    @AggregateIdentifier
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private UserId id;

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

    public Artist(UserId id, Username username, Password password, AuditTrail auditTrail, Firstname firstname, Lastname lastname, Alias alias, Description description, Phrase phrase, Image image, Link instagramLink, Link facebookLink, Link twitterLink) {
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
    }

    protected Artist(){

    }

}
