package com.codegun.jpa.multiplicity.entity;

import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@NoArgsConstructor
@MappedSuperclass
public abstract class TimeVersionEntity {
    private ZonedDateTime createdAt;
    private ZonedDateTime registeredAt;
    private ZonedDateTime lastReceivedAt;

    public TimeVersionEntity(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
        this.lastReceivedAt = createdAt;
        this.registeredAt = ZonedDateTime.now(ZoneOffset.UTC);
    }

    public void applyVersion(ZonedDateTime sentAt) {
        this.lastReceivedAt = sentAt;
    }

    public ZonedDateTime lastReceivedAt() {
        return lastReceivedAt;
    }

    public boolean isNewerThan(ZonedDateTime receivedAt) {
        return lastReceivedAt.isAfter(receivedAt);
    }
}
