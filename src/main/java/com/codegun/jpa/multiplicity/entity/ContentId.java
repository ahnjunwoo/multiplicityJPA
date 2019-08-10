package com.codegun.jpa.multiplicity.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ContentId {
    private String id;

    public ContentId(final String id) {
        this.id = id;
    }

    public static ContentId fromString(String id) {
        return new ContentId(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
