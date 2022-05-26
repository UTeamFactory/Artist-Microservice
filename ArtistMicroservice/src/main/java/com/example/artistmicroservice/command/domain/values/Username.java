package com.example.artistmicroservice.command.domain.values;

import com.example.artistmicroservice.common.application.Notification;
import com.example.artistmicroservice.common.application.Result;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Username {
    private String value;
    private final static int MAX_LENGTH = 30;

    public Username(String username) {
        value = username;
    }

    protected Username() {
        value = "";
    }

    public static Result<Username, Notification> create(String username) {
        Notification notification = new Notification();
        username = username == null ? "" : username.trim();

        if(username.isEmpty()){
            notification.addError("Username is required", null);
            return Result.failure(notification);
        }

        if(username.length() > MAX_LENGTH){
            notification.addError("The maximum length of an username is " + MAX_LENGTH + " characters including spaces", null);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new Username(username));
    }

}
