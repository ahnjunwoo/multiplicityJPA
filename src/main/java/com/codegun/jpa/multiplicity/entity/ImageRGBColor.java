package com.codegun.jpa.multiplicity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 * Created by kimyc on 09/07/2019.
 */
@Embeddable
@Access(AccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageRGBColor {
    private Float blue;
    private Float green;
    private Float red;

}
