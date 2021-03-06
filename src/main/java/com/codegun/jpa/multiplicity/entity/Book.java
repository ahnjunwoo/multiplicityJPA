package com.codegun.jpa.multiplicity.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name="book")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @Column(name = "no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_no")
    private Category category;

    @Builder
    public Book(String title, Category category) {
        this.title = title;
        this.category = category;
    }
}