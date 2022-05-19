package command.domain.values;

import common.application.Notification;
import common.application.Result;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class SpecialtyName {
    private String value;
    private final static int MAX_LENGTH = 75;

    private SpecialtyName(String specialtyName) {
        value = specialtyName;
    }

    protected SpecialtyName() {
        value = "";
    }

    public static Result<SpecialtyName, Notification> create(String specialtyName) {
        Notification notification = new Notification();
        specialtyName = specialtyName == null ? "" : specialtyName.trim();

        if(specialtyName.isEmpty()){
            notification.addError("Specialty Name is required", null);
            return Result.failure(notification);
        }

        if(specialtyName.length() > MAX_LENGTH){
            notification.addError("The maximum length of a specialty name is " + MAX_LENGTH + " characters including spaces", null);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new SpecialtyName(specialtyName));
    }

}
