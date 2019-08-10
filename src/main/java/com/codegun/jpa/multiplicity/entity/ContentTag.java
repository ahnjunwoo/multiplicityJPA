package com.codegun.jpa.multiplicity.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Entity
public class ContentTag {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(length = 80, unique = true)
    private String name;

    @Version
    private int version;

    public ContentTag(String name) {
        this.name = name;
    }

}
