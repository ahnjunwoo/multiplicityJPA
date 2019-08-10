package com.codegun.jpa.multiplicity.repository;


import com.codegun.jpa.multiplicity.entity.Sticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Long> {
}
