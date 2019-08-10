package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findById(String id);
}
