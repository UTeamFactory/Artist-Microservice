package com.example.artistmicroservice.command.domain.entities;

import com.example.artistmicroservice.command.domain.values.*;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.*;

@Aggregate
public class User {

    @AggregateIdentifier
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private String userId;

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

   /* public User(UserId id, Username username, Password password, AuditTrail auditTrail) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setAuditTrail(auditTrail);
    }*/

    protected User(){}


}
