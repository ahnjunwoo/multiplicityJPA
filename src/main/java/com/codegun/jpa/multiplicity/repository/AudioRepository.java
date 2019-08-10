package com.codegun.jpa.multiplicity.repository;

import com.codegun.jpa.multiplicity.entity.Audio;
import com.codegun.jpa.multiplicity.entity.ContentId;
import com.codegun.jpa.multiplicity.enumType.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudioRepository extends JpaRepository<Audio, Long> {
    Audio findByContentId(ContentId contentId);

    Audio save(Audio newAudio);

    List<Audio> findByStatus(Status status);

}
