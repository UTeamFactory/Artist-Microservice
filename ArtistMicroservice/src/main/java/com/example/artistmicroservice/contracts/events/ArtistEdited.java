package com.example.artistmicroservice.contracts.events;

import lombok.Value;
import java.time.Instant;

@Value
public class ArtistEdited {
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
    private Instant ocurredOn;
}
