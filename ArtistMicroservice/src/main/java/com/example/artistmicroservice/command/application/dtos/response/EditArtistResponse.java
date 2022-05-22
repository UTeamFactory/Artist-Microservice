package com.example.artistmicroservice.command.application.dtos.response;

import lombok.Getter;
import lombok.Value;

@Value
public class EditArtistResponse {
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
}
