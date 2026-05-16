package io.github.dontmashme.tennisladder.repository;

import io.github.dontmashme.tennisladder.entity.ChallengeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<ChallengeEntity, Long> {
}
