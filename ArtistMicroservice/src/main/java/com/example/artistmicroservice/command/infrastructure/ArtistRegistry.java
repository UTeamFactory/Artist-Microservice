package com.example.artistmicroservice.command.infrastructure;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArtistRegistry {
    @Id
    @Column
    public String artistId;

    private String firstname;
    private String lastname;
    private String alias;
    private String description;
    private String phrase;
    private String image;
    private String instagramlink;
    private String twitterlink;
    private String facebooklink;

    public ArtistRegistry(){}

    public ArtistRegistry(String artistId, String firstname, String lastname, String alias, String description, String phrase, String image, String instagramlink, String twitterlink, String facebooklink) {
        this.artistId = artistId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.alias = alias;
        this.description = description;
        this.phrase = phrase;
        this.image = image;
        this.instagramlink = instagramlink;
        this.twitterlink = twitterlink;
        this.facebooklink = facebooklink;
    }

    public String getArtistId() {
        return artistId;
    }

    public ArtistRegistry setArtistId(String artistId) {
        this.artistId = artistId;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ArtistRegistry setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ArtistRegistry setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public ArtistRegistry setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArtistRegistry setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPhrase() {
        return phrase;
    }

    public ArtistRegistry setPhrase(String phrase) {
        this.phrase = phrase;
        return this;
    }

    public String getImage() {
        return image;
    }

    public ArtistRegistry setImage(String image) {
        this.image = image;
        return this;
    }

    public String getInstagramlink() {
        return instagramlink;
    }

    public ArtistRegistry setInstagramlink(String instagramlink) {
        this.instagramlink = instagramlink;
        return this;
    }

    public String getTwitterlink() {
        return twitterlink;
    }

    public ArtistRegistry setTwitterlink(String twitterlink) {
        this.twitterlink = twitterlink;
        return this;
    }

    public String getFacebooklink() {
        return facebooklink;
    }

    public ArtistRegistry setFacebooklink(String facebooklink) {
        this.facebooklink = facebooklink;
        return this;
    }
}
