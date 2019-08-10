package com.codegun.jpa.multiplicity.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@Embeddable
public class StickerImage {
    public enum Type{
        MAIN, TAB, ITEM
    }

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Type type;
    @Column(length = 1024)
    private String imageUrl;

    public StickerImage(Type type, String imageUrl) {
        this.type = type;
        this.imageUrl = imageUrl;
    }

    public Type type(){
        return this.type;
    }

    public String imageUrl(){
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
