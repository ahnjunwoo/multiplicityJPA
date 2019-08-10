package com.codegun.jpa.multiplicity.entity;

import com.codegun.jpa.multiplicity.enumType.Language;
import com.codegun.jpa.multiplicity.enumType.SalesType;
import com.codegun.jpa.multiplicity.enumType.Status;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.time.ZonedDateTime;
import java.util.Map;

@NoArgsConstructor
@Entity
@DiscriminatorValue("SI")
public class StockImage extends Content {
    @Column(length = 1024)
    private String imageUrl;

    @Embedded
    private ImageExtInfo extInfo;

    public StockImage(ContentId contentId, Map<Language, ContentDesc> textContents, String mainImage,  Map<SalesType, Money> salesPolicies,
                      CreatorId ownerId, Status status, ZonedDateTime createdAt, String imageUrl, ImageExtInfo extInfo) {
        super(contentId, textContents, mainImage, salesPolicies, ownerId, status, createdAt);
        this.imageUrl = imageUrl;
        this.extInfo = extInfo;
    }

    public String imageUrl() {
        return imageUrl;
    }
    public ImageExtInfo imageExtInfo() {
        return extInfo;
    }

    public void updateImage(String imageUrl) {
        if(!StringUtils.isEmpty(imageUrl) && !imageUrl.equals(this.imageUrl)) {
            this.imageUrl = imageUrl;
        }
    }

    public void updateExtInfo(ImageExtInfo extInfo) {
        if((extInfo != null) && !extInfo.equals(this.extInfo)) {
            this.extInfo = extInfo;
        }
    }

    public Boolean isPortrait() {
        if(extInfo == null) {
            return null;
        }
        return extInfo.isPortrait();
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
