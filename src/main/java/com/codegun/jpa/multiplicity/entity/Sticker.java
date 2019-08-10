package com.codegun.jpa.multiplicity.entity;

import com.codegun.jpa.multiplicity.enumType.Language;
import com.codegun.jpa.multiplicity.enumType.SalesType;
import com.codegun.jpa.multiplicity.enumType.Status;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Entity
@DiscriminatorValue("S")
public class Sticker extends Content {
    private boolean animated;

    @ElementCollection
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name="sticker_images", joinColumns = @JoinColumn(name = "content_seq", referencedColumnName = "id"))
    @MapKeyColumn(name = "name", length = 80)
    private Map<String, StickerImage> stickerImages = new HashMap<>();

    public Sticker(ContentId contentId, Map<Language, ContentDesc> textContents, String mainImage,
                   Map<SalesType, Money> salesPolicies, CreatorId ownerId, Status status, ZonedDateTime createdAt,
                   boolean animated, Map<String, StickerImage> stickerImages) {
        super(contentId, textContents, mainImage, salesPolicies, ownerId, status, createdAt);
        this.animated = animated;
        this.stickerImages = stickerImages;
    }
}
