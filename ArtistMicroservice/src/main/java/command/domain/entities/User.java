package command.domain.entities;

import command.domain.values.AuditTrail;
import command.domain.values.Password;
import command.domain.values.UserId;
import command.domain.values.Username;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;

import javax.persistence.*;


@Entity(name = "User")
@Table(name = "users")
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @AggregateIdentifier
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private UserId id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "username", length = 30, nullable = false))
    })
    private Username username;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "password", length = 75, nullable = false))
    })
    private Password password;

    @Embedded
    private AuditTrail auditTrail;

    public User(UserId id, Username username, Password password, AuditTrail auditTrail) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setAuditTrail(auditTrail);
    }

    protected User(){}


}
