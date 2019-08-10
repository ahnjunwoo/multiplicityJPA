package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Blog findByName(String name);
}
