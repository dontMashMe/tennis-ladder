package io.github.dontmashme.tennisladder.service.ladder;

import io.github.dontmashme.tennisladder.dto.ladder.CreateLadderRequest;
import io.github.dontmashme.tennisladder.entity.LadderEntity;

import java.util.List;

public interface LadderService {
    LadderEntity saveLadder(CreateLadderRequest ladder);
    List<LadderEntity> fetchAllLadders();
    LadderEntity updateLadder(Long id, LadderEntity updated);
    void deleteLadderById(Long id);
}
