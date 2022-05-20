package command.application.dtos.request;

import lombok.Value;

@Value
public class RegisterArtistRequest {
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
