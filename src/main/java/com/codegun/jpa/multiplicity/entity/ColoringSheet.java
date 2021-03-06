package com.codegun.jpa.multiplicity.entity;


import com.codegun.jpa.multiplicity.enumType.Language;
import com.codegun.jpa.multiplicity.enumType.SalesType;
import com.codegun.jpa.multiplicity.enumType.Status;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.ZonedDateTime;
import java.util.Map;

@NoArgsConstructor
@Entity
@DiscriminatorValue("CS")
public class ColoringSheet extends Content {
    @Column(length = 1024)
    private String imageUrl;

    @Column(length = 1024, name = "before_file_url")
    private String beforeImageUrl;

    @Column(length = 1024, name = "ext_file_url")
    private String afterImageUrl;

    public ColoringSheet(ContentId contentId, Map<Language, ContentDesc> textContents, String mainImage, Map<SalesType, Money> salesPolicies,
                         CreatorId ownerId, Status status, ZonedDateTime createdAt, String imageUrl, String beforeImageUrl, String afterImageUrl) {
        super(contentId, textContents, mainImage, salesPolicies, ownerId, status, createdAt);
        this.imageUrl = imageUrl;
        this.beforeImageUrl = beforeImageUrl;
        this.afterImageUrl = afterImageUrl;
    }
}
