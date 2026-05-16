package io.github.dontmashme.tennisladder.service.ladderentry;

import io.github.dontmashme.tennisladder.entity.LadderEntryEntity;

import java.util.List;

public interface LadderEntryService {
    LadderEntryEntity saveLadderEntry(LadderEntryEntity ladderEntry);
    List<LadderEntryEntity> fetchAllLadderEntries();
    LadderEntryEntity updateLadderEntry(Long id, LadderEntryEntity updated);
    void deleteLadderEntryById(Long id);
}
