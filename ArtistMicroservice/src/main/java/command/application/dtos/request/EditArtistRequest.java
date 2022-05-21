package command.application.dtos.request;

import lombok.Getter;
import lombok.Setter;

public class EditArtistRequest {
    private @Getter @Setter String id;
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
