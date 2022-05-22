package com.example.artistmicroservice.command.domain.values;

import com.example.artistmicroservice.common.application.Notification;
import com.example.artistmicroservice.common.application.Result;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Password {

    private String value;
    private final static int MAX_LENGTH = 30;
    private final static int MIN_LENGTH = 6;

    private Password(String password) {
        value = password;
    }

    protected Password() {
        value = "";
    }

    public static Result<Password, Notification> create(String password) {
        Notification notification = new Notification();
        password = password == null ? "" : password.trim();

        if(password.isEmpty()){
            notification.addError("Password is required", null);
            return Result.failure(notification);
        }

        if(password.length() < MIN_LENGTH){
            notification.addError("The minimum length of a password is " + MIN_LENGTH + " characters including spaces", null);
        }

        if(password.length() > MAX_LENGTH){
            notification.addError("The maximum length of a password is " + MAX_LENGTH + " characters including spaces", null);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new Password(password));
    }
}
