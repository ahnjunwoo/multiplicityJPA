package com.codegun.jpa.multiplicity.entity;


import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ImageExtInfo {
    private Integer width;
    private Integer height;
    private Integer people;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "imageColorMap",
            joinColumns = @JoinColumn(name = "contentSeq", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dominantColorSeq", referencedColumnName = "id"))
    private Set<DominantColors> dominantColors = new HashSet<>();

    public ImageExtInfo(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public ImageExtInfo(Integer width, Integer height, Integer people){
        this.width = width;
        this.height = height;
        this.people = people;
    }

    public ImageExtInfo(Integer width, Integer height, Integer people, Set<DominantColors> dominantColors){
        this.width = width;
        this.height = height;
        this.people = people;
        this.dominantColors = dominantColors;
    }

    public Boolean isPortrait() {
        return this.height > this.width;
    }

    public Integer width(){
        return this.width;
    }

    public Integer height(){
        return this.height;
    }

    public Integer people() { return this.people; }

    public Set<DominantColors> dominantColors(){ return this.dominantColors; }
}
