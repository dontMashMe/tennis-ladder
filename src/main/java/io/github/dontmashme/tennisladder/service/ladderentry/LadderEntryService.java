package io.github.dontmashme.tennisladder.service.ladderentry;

import io.github.dontmashme.tennisladder.dto.ladderentry.CreateLadderEntryRequest;
import io.github.dontmashme.tennisladder.entity.LadderEntryEntity;

import java.util.List;

public interface LadderEntryService {
    LadderEntryEntity saveLadderEntry(CreateLadderEntryRequest ladderEntry);
    List<LadderEntryEntity> fetchAllLadderEntries();
    LadderEntryEntity updateLadderEntry(Long id, LadderEntryEntity updated);
    void deleteLadderEntryById(Long id);
}
