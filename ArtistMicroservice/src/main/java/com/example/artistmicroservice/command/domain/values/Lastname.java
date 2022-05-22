package com.example.artistmicroservice.command.domain.values;

import com.example.artistmicroservice.common.application.Notification;
import com.example.artistmicroservice.common.application.Result;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Lastname {

    private String value;
    private final static int MAX_LENGTH = 75;

    private Lastname(String lastname){
        value = lastname;
    }

    protected Lastname(){
        value = "";
    }

    public static Result<Lastname, Notification> create(String lastname) {
        Notification notification = new Notification();
        lastname = lastname == null ? "" : lastname.trim();

        if(lastname.isEmpty()){
            notification.addError("lastname is required", null);
            return Result.failure(notification);
        }

        if(lastname.length() > MAX_LENGTH){
            notification.addError("The maximum length of a lastname " + MAX_LENGTH + " characters including spaces", null);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new Lastname(lastname));
    }

}
