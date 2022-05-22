package com.example.artistmicroservice.command.domain.entities;

import com.example.artistmicroservice.command.domain.values.*;

import javax.persistence.*;

@Entity(name = "Specialty")
@Table(name = "specialties")
public class Specialty {

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
