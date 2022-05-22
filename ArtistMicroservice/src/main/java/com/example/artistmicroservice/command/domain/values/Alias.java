package com.example.artistmicroservice.command.domain.values;

import com.example.artistmicroservice.common.application.Notification;
import com.example.artistmicroservice.common.application.Result;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Alias {

    private String value;
    private final static int MAX_LENGTH = 50;

    private Alias(String alias){
        value = alias;
    }

    protected Alias(){
        value = "";
    }

    public static Result<Alias, Notification> create(String alias) {
        Notification notification = new Notification();
        alias = alias == null ? "" : alias.trim();

        if(alias.isEmpty()){
            notification.addError("alias is required", null);
            return Result.failure(notification);
        }

        if(alias.length() > MAX_LENGTH){
            notification.addError("The maximum length of an alias is " + MAX_LENGTH + " characters including spaces", null);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new Alias(alias));
    }
}
