package com.codegun.jpa.multiplicity.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category2")
@Data
@NoArgsConstructor
public class Category2 {
    @Id
    @Column(name="no")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer no;

    @Column( name="name", nullable=false, length=100 )
    private String name;

    @OneToMany(mappedBy="category2") //mappedBy 속성을 사용해서 속성의 값으로 연관관계의 주인이 아니고 북이 주인이라는것 명시
    private List<Book2> books = new ArrayList<>();

    @Builder
    public Category2(String name, List<Book2> books) {
        this.name = name;
        this.books = books;
    }
}
