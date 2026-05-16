package io.github.dontmashme.tennisladder.service.challenge;

import io.github.dontmashme.tennisladder.entity.ChallengeEntity;

import java.util.List;

public interface ChallengeService {
    ChallengeEntity saveChallenge(ChallengeEntity challenge);
    List<ChallengeEntity> fetchAllChallenges();
    ChallengeEntity updateChallenge(Long id, ChallengeEntity updated);
    void deleteChallengeById(Long id);
}
