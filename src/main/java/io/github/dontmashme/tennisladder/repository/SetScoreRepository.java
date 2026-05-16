package io.github.dontmashme.tennisladder.repository;

import io.github.dontmashme.tennisladder.entity.SetScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetScoreRepository extends JpaRepository<SetScoreEntity, Long> {
}
