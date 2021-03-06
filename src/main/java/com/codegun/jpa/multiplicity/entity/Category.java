package com.codegun.jpa.multiplicity.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="category")
@Data
@NoArgsConstructor
public class Category {
    @Id
    @Column(name="no")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer no;

    @Column( name="name", nullable=false, length=100 )
    private String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }
}
