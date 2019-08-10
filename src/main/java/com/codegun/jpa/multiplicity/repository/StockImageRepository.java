package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.StockImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockImageRepository extends JpaRepository<StockImage, Long> {
}
