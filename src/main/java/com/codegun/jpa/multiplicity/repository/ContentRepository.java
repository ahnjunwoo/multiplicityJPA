package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends  JpaRepository<Content, Long> {
}
