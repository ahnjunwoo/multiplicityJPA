package com.codegun.jpa.multiplicity;

import com.codegun.jpa.multiplicity.entity.*;
import com.codegun.jpa.multiplicity.enumType.Currency;
import com.codegun.jpa.multiplicity.enumType.Language;
import com.codegun.jpa.multiplicity.enumType.SalesType;
import com.codegun.jpa.multiplicity.enumType.Status;
import com.codegun.jpa.multiplicity.repository.StickerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.ZonedDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StickerServiceTest {
    @Autowired
    private StickerRepository stickerRepository;

    private ZonedDateTime createdAt = ZonedDateTime.now();

    @Test
    public void 신규_스티커_추가() {
        ContentId newContentId = ContentId.fromString("newContentId");
        Map<Language, ContentDesc> textContents = new HashMap<>();
        textContents.put(Language.KO, new ContentDesc("한글제목", "한글내용"));

        Map<SalesType, Money> salesPolicies = new HashMap<>();
        salesPolicies.put(SalesType.STREAM, new Money(100, Currency.KRW));

        Map<String, StickerImage > stickerImages = new HashMap<>();
        stickerImages.put("main.jpg", new StickerImage(StickerImage.Type.MAIN, "mainImageUrl"));
        stickerImages.put("1.jpg", new StickerImage(StickerImage.Type.ITEM, "itemImageUrl"));

        Sticker newSticker = new Sticker(newContentId, textContents, "mainImageUrl",
                salesPolicies, CreatorId.fromString("creatorId"), Status.ENABLED, createdAt, false, stickerImages);
        stickerRepository.save(newSticker);
    }

}