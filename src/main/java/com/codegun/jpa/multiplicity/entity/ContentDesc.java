package com.codegun.jpa.multiplicity.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ContentDesc {
    @Column(length = 80)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;

    public ContentDesc(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String title(){
        return this.title;
    }

    public String description(){
        return this.description;
    }
}
