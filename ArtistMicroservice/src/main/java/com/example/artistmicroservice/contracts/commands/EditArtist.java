package com.example.artistmicroservice.contracts.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class EditArtist {

    @TargetAggregateIdentifier
    private String artistId;
    private String firstName;
    private String lastName;
    private String alias;
    private String description;
    private String phrase;
    private String image;
    private String instagramLink;
    private String facebookLink;
    private String twitterLink;

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getAlias() {
        return alias;
    }

    public String getDescription() {
        return description;
    }

    public String getPhrase() {
        return phrase;
    }

    public String getImage() {
        return image;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public String getArtistId() {
        return artistId;
    }

    public EditArtist(String artistId, String firstName, String lastName, String alias, String description, String phrase, String image, String instagramLink, String facebookLink, String twitterLink) {
        this.artistId = artistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.description = description;
        this.phrase = phrase;
        this.image = image;
        this.instagramLink = instagramLink;
        this.facebookLink = facebookLink;
        this.twitterLink = twitterLink;
    }
}
