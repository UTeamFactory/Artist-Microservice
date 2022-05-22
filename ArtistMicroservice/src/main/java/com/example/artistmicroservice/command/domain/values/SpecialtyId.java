package com.example.artistmicroservice.command.domain.values;

import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class SpecialtyId implements Serializable {
    private UUID value;

    private SpecialtyId(UUID value) {
        this.value = value;
    }

    protected SpecialtyId() {
        this.value = UUID.randomUUID();
    }
}
