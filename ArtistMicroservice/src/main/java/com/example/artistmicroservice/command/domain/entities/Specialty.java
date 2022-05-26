package com.example.artistmicroservice.command.domain.entities;

import com.example.artistmicroservice.command.domain.values.*;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import javax.persistence.*;

@Aggregate
public class Specialty {

    @AggregateIdentifier
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BINARY(16)"))
    })
    private SpecialtyId id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "specialty_name", length = 75, nullable = false))
    })
    private SpecialtyName specialtyName;

}
