package com.codegun.jpa.multiplicity.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="member")
@Setter
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="no")
    private Integer no;

    @Column(name="id")
    private String id;

    @ManyToMany
    @JoinTable(name="user_product",
            joinColumns = @JoinColumn(name = "user_no"),
            inverseJoinColumns = @JoinColumn(name = "product_no"))
    private List<Product> product = new ArrayList<>();

    @Builder
    public Member(String id, List<Product> product) {
        this.id = id;
        this.product = product;
    }
}
