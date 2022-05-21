package contracts.commands;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class EditArtist {

    @TargetAggregateIdentifier
    private String firstname;
    private String lastname;
    private String alias;
    private String description;
    private String phrase;
    private String image;
    private String instagramLink;
    private String facebookLink;
    private String twitterLink;

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

    public EditArtist(String firstname, String lastname, String alias, String description, String phrase, String image, String instagramLink, String facebookLink, String twitterLink) {
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
}
