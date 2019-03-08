package com.codegun.jpa.multiplicity.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="category")
@Data
public class Category {
    @Id
    @Column(name="no")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer no;

    @Column( name="name", nullable=false, length=100 )
    private String name;

}
