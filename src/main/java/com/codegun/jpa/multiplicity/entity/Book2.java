package com.codegun.jpa.multiplicity.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name="book2")
@Getter
@Setter
@NoArgsConstructor
public class Book2 {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_no2")
    private Category2 category2;

    @Builder
    public Book2(String title, Category2 category2) {
        this.title = title;
        this.category2 = category2;
    }
}