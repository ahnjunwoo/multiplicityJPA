package com.codegun.jpa.multiplicity.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="no")
    private Integer no;

    @Column(name="id")
    private String id;

    @OneToOne
    @JoinColumn(name="blog_no")
    private Blog blog;

    @Builder
    public User(String id, Blog blog) {
        this.id = id;
        this.blog = blog;
    }
}
