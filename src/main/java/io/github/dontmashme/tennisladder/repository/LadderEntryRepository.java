package io.github.dontmashme.tennisladder.repository;

import io.github.dontmashme.tennisladder.entity.LadderEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LadderEntryRepository extends JpaRepository<LadderEntryEntity, Long> {
}
