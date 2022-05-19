package command.domain.values;

import common.application.Notification;
import common.application.Result;
import lombok.Value;

import javax.persistence.Embeddable;

@Embeddable
@Value
public class Image {

    private String value;

    private Image(String image) { value = image; }

    protected Image() {
        this.value = "";
    }

    public static Result<Image, Notification> create(String image) {
        Notification notification = new Notification();
        image = image == null ? "" : image.trim();

        if(image.isEmpty()){
            notification.addError("image is required", null);
            return Result.failure(notification);
        }

        if(notification.hasErrors()) {
            return Result.failure(notification);
        }

        return Result.success(new Image(image));
    }

}
