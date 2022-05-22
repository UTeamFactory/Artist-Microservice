package com.example.artistmicroservice.command.domain.values;

import com.example.artistmicroservice.common.application.Notification;
import com.example.artistmicroservice.common.application.Result;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Phrase {

    private String value;
    private final static int MAX_LENGTH = 250;
    private final static int MIN_LENGTH = 20;

    private Phrase(String description) { value = description; }

    protected Phrase() {
        this.value = "";
    }

    public static Result<Phrase, Notification> create(String phrase) {
        Notification notification = new Notification();
        phrase = phrase == null ? "" : phrase.trim();

        if(phrase.isEmpty()){
            notification.addError("description is required", null);
            return Result.failure(notification);
        }

        if(phrase.length() > MAX_LENGTH){
            notification.addError("The maximum length of an phrase is " + MAX_LENGTH + " characters including spaces", null);
        }

        if(phrase.length() < MIN_LENGTH){
            notification.addError("The minimum length of an phrase is " + MIN_LENGTH + " characters including spaces", null);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new Phrase(phrase));
    }

}
