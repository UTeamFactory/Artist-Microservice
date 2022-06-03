package com.example.artistmicroservice.command.domain.values;

import lombok.Value;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Value(staticConstructor = "of")
public class UserId implements Serializable {
    private String value;

    private UserId(String value) {
        this.value = value;
    }

    public UserId() {
        this.value = UUID.randomUUID().toString();
    }
}
