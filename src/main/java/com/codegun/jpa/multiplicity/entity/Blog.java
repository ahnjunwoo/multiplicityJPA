package com.codegun.jpa.multiplicity.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="blog")
@Getter
@Setter
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="no")
    private Integer no;

    @Column(name="name")
    private String name;

    //양방향 설정
   /* @OneToOne(mappedBy="blog")
    private User user;*/

    @Builder
    public Blog(String name) {
        this.name = name;
    }
}
