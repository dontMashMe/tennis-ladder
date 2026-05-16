package io.github.dontmashme.tennisladder.service.ladder;

import io.github.dontmashme.tennisladder.entity.LadderEntity;

import java.util.List;

public interface LadderService {
    LadderEntity saveLadder(LadderEntity ladder);
    List<LadderEntity> fetchAllLadders();
    LadderEntity updateLadder(Long id, LadderEntity updated);
    void deleteLadderById(Long id);
}
