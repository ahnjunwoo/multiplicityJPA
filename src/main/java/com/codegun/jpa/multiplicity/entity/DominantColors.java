package com.codegun.jpa.multiplicity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by kimyc on 04/07/2019.
 */
@Entity
@Table(name = "imagePropertiesDominantColors")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class DominantColors {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Embedded
    ImageRGBColor color;

    @Column(length = 6)
    private String hex;

    private double percent;
    private int percentRounded;
    private double pixelFraction;
    private String rgb;
    private double score;
}
