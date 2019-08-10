package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.Book;
import com.codegun.jpa.multiplicity.entity.Book2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2Repository extends JpaRepository<Book2, Integer> {

    Book findByTitle(String title);
}
