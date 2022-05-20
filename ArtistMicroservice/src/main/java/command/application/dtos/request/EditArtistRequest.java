package command.application.dtos.request;

import lombok.Getter;

public class EditArtistRequest {
    private @Getter String firstname;
    private @Getter String lastname;
    private @Getter String alias;
    private @Getter String description;
    private @Getter String phrase;
    private @Getter String image;
    private @Getter String instagramLink;
    private @Getter String facebookLink;
    private @Getter String twitterLink;
}
