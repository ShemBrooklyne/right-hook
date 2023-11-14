package org.geekwys.righthooks.repository;

import org.geekwys.righthooks.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    Optional<Media> retrieveMediaByName(String fileName);
}
