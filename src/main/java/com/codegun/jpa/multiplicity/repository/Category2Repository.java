package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.Category;
import com.codegun.jpa.multiplicity.entity.Category2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Category2Repository extends JpaRepository<Category2, Integer> {
    Category2 findByName(String name);
}
