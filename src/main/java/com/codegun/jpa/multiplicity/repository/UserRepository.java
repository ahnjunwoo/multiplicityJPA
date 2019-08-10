package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(String id);
}
