package com.example.artistmicroservice.query.projections;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

public class ArtistHistoryView {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long artistHistoryId;

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

    @Getter @Setter
    private Instant createdAt;

    public ArtistHistoryView(){}

    public ArtistHistoryView(String id, String firstname, String lastname, String alias, String description, String phrase, String image, String instagramlink, String twitterlink, String facebooklink, Instant createdAt) {
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
        this.createdAt = createdAt;
    }

    public ArtistHistoryView(ArtistHistoryView artistHistoryView) {
        this.id = artistHistoryView.getId();
        this.firstname = artistHistoryView.getFirstname();
        this.lastname = artistHistoryView.getLastname();
        this.alias = artistHistoryView.getAlias();
        this.description = artistHistoryView.getDescription();
        this.phrase = artistHistoryView.getPhrase();
        this.image = artistHistoryView.getImage();
        this.instagramlink = artistHistoryView.getInstagramlink();
        this.twitterlink = artistHistoryView.getTwitterlink();
        this.facebooklink = artistHistoryView.getFacebooklink();
        this.createdAt = artistHistoryView.getCreatedAt();
    }
}
