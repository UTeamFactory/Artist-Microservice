package com.example.artistmicroservice.query.projections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ArtistView {

    @Id
    @Column(length = 36) @Getter @Setter
    private String id;

    @Column(length=75) @Getter @Setter
    private String firstname;

    @Column(length=75) @Getter @Setter
    private String lastname;

    @Column(length=75) @Getter @Setter
    private String alias;

    @Column(length=200) @Getter @Setter
    private String description;

    @Column(length=200) @Getter @Setter
    private String phrase;

    @Column() @Getter @Setter
    private String image;

    @Column(nullable = true) @Getter @Setter
    private String instagramlink;

    @Column(nullable = true) @Getter @Setter
    private String twitterlink;

    @Column(nullable = true) @Getter @Setter
    private String facebooklink;

    public ArtistView() {
    }

    public ArtistView(String id, String firstname, String lastname, String alias, String description, String phrase, String image, String instagramlink, String twitterlink, String facebooklink) {
        this.id = id;
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
}
