package command.domain.values;

import common.application.Notification;
import common.application.Result;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Embeddable
@Value
public class AuditTrail {

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "created_by"))
    })
    private UserId createdBy;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "updated_by"))
    })
    private UserId updatedBy;

    private AuditTrail(LocalDateTime createdAt, LocalDateTime updatedAt, UserId createdBy, UserId updatedBy) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    protected AuditTrail() {
        this.createdAt = null;
        this.updatedAt = null;
        this.createdBy = null;
        this.updatedBy = null;
    }

    public static Result<AuditTrail, Notification> create(UUID createdBy) {

        return Result.success(new AuditTrail(LocalDateTime.now(ZoneOffset.UTC), null, UserId.of(createdBy), null));
    }
}
