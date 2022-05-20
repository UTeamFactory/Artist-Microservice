package command.domain.entities;

import command.domain.values.*;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.*;

@Entity(name = "Artist")
@Table(name = "artists")
@Data
@Aggregate
public class ArtistValue extends  User {

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "firstname", length = 75, nullable = false))
    })
    private Firstname firstname;


    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "lastname", length = 75, nullable = false))
    })
    private Lastname lastname;

    @AggregateIdentifier
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "alias", length = 75, nullable = false))
    })
    private Alias alias;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "description", length = 200, nullable = false))
    })
    private Description description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "phrase", length = 200, nullable = false))
    })
    private Phrase phrase;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "image", nullable = false))
    })
    private Image image;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "instagram_link", nullable = true))
    })
    private Link instagramLink;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "facebook_link", nullable = true))
    })
    private Link facebookLink;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "twitter_link", nullable = true))
    })
    private Link twitterLink;

    public ArtistValue(UserId id, Username username, Password password, AuditTrail auditTrail, Firstname firstname, Lastname lastname, Alias alias, Description description, Phrase phrase, Image image, Link instagramLink, Link facebookLink, Link twitterLink) {
        super(id, username, password, auditTrail);
        setFirstname(firstname);
        setLastname(lastname);
        setAlias(alias);
        setDescription(description);
        setPhrase(phrase);
        setImage(image);
        setInstagramLink(instagramLink);
        setFacebookLink(facebookLink);
        setTwitterLink(twitterLink);
    }

    protected ArtistValue(){

    }

}
