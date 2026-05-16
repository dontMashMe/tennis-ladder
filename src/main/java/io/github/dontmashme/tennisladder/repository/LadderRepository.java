package io.github.dontmashme.tennisladder.repository;

import io.github.dontmashme.tennisladder.entity.LadderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LadderRepository extends JpaRepository<LadderEntity, Long> {
}
