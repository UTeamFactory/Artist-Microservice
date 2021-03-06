package com.example.artistmicroservice.command.domain.values;

import com.example.artistmicroservice.common.application.Result;
import com.example.artistmicroservice.common.application.Notification;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Firstname {

    private String value;
    private final static int MAX_LENGTH = 75;

    public Firstname(String firstname){
        value = firstname;
    }

    protected Firstname(){
        value = "";
    }

    public static Result<Firstname, Notification> create(String firstname) {
        Notification notification = new Notification();
        firstname = firstname == null ? "" : firstname.trim();

        if(firstname.isEmpty()){
            notification.addError("firstname is required", null);
            return Result.failure(notification);
        }

        if(firstname.length() > MAX_LENGTH){
            notification.addError("The maximum length of a firstname " + MAX_LENGTH + " characters including spaces", null);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new Firstname(firstname));
    }

}
