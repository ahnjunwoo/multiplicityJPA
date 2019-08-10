package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.ColoringSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColoringSheetRepository extends JpaRepository<ColoringSheet, Long> {
}
