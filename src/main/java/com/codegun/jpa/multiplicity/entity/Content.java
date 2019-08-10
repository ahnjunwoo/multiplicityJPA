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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 2)
public abstract class Content extends TimeVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "content_id", unique = true, length = 40))
    private ContentId contentId;

    @ElementCollection
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name = "content_desc", joinColumns = @JoinColumn(name = "content_seq", referencedColumnName = "id"))
    @MapKeyJoinColumn(name = "language")
    @MapKeyColumn(name = "language", length = 10)
    @MapKeyEnumerated(EnumType.STRING)
    private Map<Language, ContentDesc> textContents = new HashMap<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "content_tag_map",
            joinColumns = @JoinColumn(name = "content_seq", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "content_tag_seq", referencedColumnName = "id"))
    private Set<ContentTag> tags = new HashSet<>();

    @Column(length = 1024)
    private String mainImage;

    @ElementCollection
    @Fetch(FetchMode.SUBSELECT)
    @CollectionTable(name = "sales_policy", joinColumns = @JoinColumn(name = "content_seq", referencedColumnName = "id"))
    @MapKeyJoinColumn(name = "sales_type")
    @MapKeyColumn(name = "sales_type", length = 20)
    @MapKeyEnumerated(EnumType.STRING)
    private Map<SalesType, Money> salesPolicies = new HashMap<>();

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "owner_id", length = 40))
    private CreatorId ownerId;

    public Content(ContentId contentId, Map<Language, ContentDesc> textContents, String mainImage,
                   Map<SalesType, Money> salesPolicies, CreatorId ownerId, Status status, ZonedDateTime createdAt) {
        super(createdAt);
        this.contentId = contentId;
        this.textContents = textContents;
        this.status = status;
        this.mainImage = mainImage;
        this.salesPolicies = salesPolicies;
        this.ownerId = ownerId;
    }

}