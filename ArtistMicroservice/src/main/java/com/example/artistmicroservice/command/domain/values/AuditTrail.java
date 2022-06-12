package com.example.artistmicroservice.command.domain.values;

import com.example.artistmicroservice.common.application.Result;
import com.example.artistmicroservice.common.application.Notification;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
    private ArtistId createdBy;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "updated_by"))
    })
    private ArtistId updatedBy;

    private AuditTrail(LocalDateTime createdAt, LocalDateTime updatedAt, ArtistId createdBy, ArtistId updatedBy) {
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

    public static Result<AuditTrail, Notification> create(String createdBy) {

        return Result.success(new AuditTrail(LocalDateTime.now(ZoneOffset.UTC), null, ArtistId.of(createdBy), null));
    }
}
