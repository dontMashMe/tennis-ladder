package io.github.dontmashme.tennisladder.service.setscore;

import io.github.dontmashme.tennisladder.entity.SetScoreEntity;

import java.util.List;

public interface SetScoreService {
    SetScoreEntity saveSetScore(SetScoreEntity setScore);
    List<SetScoreEntity> fetchAllSetScores();
    SetScoreEntity updateSetScore(Long id, SetScoreEntity updated);
    void deleteSetScoreById(Long id);
}
