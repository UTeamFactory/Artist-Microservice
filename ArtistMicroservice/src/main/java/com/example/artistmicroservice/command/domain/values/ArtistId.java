package com.example.artistmicroservice.command.domain.values;

import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class ArtistId implements Serializable {
    private String value;

    public ArtistId(String value) {
        this.value = value;
    }

    protected ArtistId() {
        this.value = UUID.randomUUID().toString();
    }
}
