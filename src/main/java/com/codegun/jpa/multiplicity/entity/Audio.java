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
@DiscriminatorValue("A")
public class Audio extends Content {
    @Column(length = 1024)
    private String imageUrl;

    @Column(length = 1024, name = "ext_file_url")
    private String audioFileUrl;

    public Audio(ContentId contentId, Map<Language, ContentDesc> textContents, String mainImage, Map<SalesType, Money> salesPolicies, CreatorId ownerId, Status status, ZonedDateTime createdAt, String imageUrl, String audioFileUrl) {
        super(contentId, textContents, mainImage, salesPolicies, ownerId, status, createdAt);
        this.imageUrl = imageUrl;
        this.audioFileUrl = audioFileUrl;
    }
}