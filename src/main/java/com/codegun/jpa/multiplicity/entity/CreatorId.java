package com.codegun.jpa.multiplicity.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public final class CreatorId {
    private String id;

    public CreatorId(final String id) {
        this.id = id;
    }

    public static CreatorId fromString(String id) {
        return new CreatorId(id);
    }


    public String idString() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }


}
