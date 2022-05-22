package com.example.artistmicroservice.contracts.events;

import lombok.Value;

@Value
public class ArtistRegistered {

    private String id;
    private String firstname;
    private String lastname;
    private String alias;
    private String description;
    private String phrase;
    private String image;
    private String instagramLink;
    private String facebookLink;
    private String twitterLink;

    public ArtistRegistered(String id, String firstname, String lastname, String alias, String description, String phrase, String image, String instagramLink, String facebookLink, String twitterLink) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.alias = alias;
        this.description = description;
        this.phrase = phrase;
        this.image = image;
        this.instagramLink = instagramLink;
        this.facebookLink = facebookLink;
        this.twitterLink = twitterLink;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
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
}
