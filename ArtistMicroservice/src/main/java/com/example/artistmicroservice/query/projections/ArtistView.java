package com.example.artistmicroservice.query.projections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class ArtistView {
    @Id
    @Column(length = 36) @Getter @Setter
    private String artistId;

    @Column(length=75) @Getter @Setter
    private String firstName;

    @Column(length=75) @Getter @Setter
    private String lastName;

    @Column(length=75) @Getter @Setter
    private String alias;

    @Column(length=200) @Getter @Setter
    private String description;

    @Column(length=200) @Getter @Setter
    private String phrase;

    @Column() @Getter @Setter
    private String image;

    @Column(nullable = true) @Getter @Setter
    private String instagramLink;

    @Column(nullable = true) @Getter @Setter
    private String twitterLink;

    @Column(nullable = true) @Getter @Setter
    private String facebookLink;

    private Instant createdAt;

    @Column(nullable = true) @Getter @Setter
    private Instant updatedAt;

    public ArtistView() {
    }

    public ArtistView(String artistId, String firstName, String lastName, String alias, String description, String phrase, String image, String instagramLink, String twitterLink, String facebookLink, Instant createdAt) {
        this.artistId = artistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.alias = alias;
        this.description = description;
        this.phrase = phrase;
        this.image = image;
        this.instagramLink = instagramLink;
        this.twitterLink = twitterLink;
        this.facebookLink = facebookLink;
        this.createdAt = createdAt;
    }
}
