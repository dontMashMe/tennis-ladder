package io.github.dontmashme.tennisladder.service.challenge;

import io.github.dontmashme.tennisladder.entity.ChallengeEntity;
import io.github.dontmashme.tennisladder.repository.ChallengeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository repository;

    public ChallengeServiceImpl(ChallengeRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChallengeEntity saveChallenge(ChallengeEntity challenge) {
        return this.repository.save(challenge);
    }

    @Override
    public List<ChallengeEntity> fetchAllChallenges() {
        return this.repository.findAll();
    }

    @Override
    public ChallengeEntity updateChallenge(Long id, ChallengeEntity updated) {
        var challenge = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Challenge not found: " + id));

        challenge.setLadder(updated.getLadder());
        challenge.setChallengerEntry(updated.getChallengerEntry());
        challenge.setChallengedEntry(updated.getChallengedEntry());
        challenge.setStatus(updated.getStatus());
        challenge.setMessage(updated.getMessage());
        challenge.setExpiresAt(updated.getExpiresAt());
        challenge.setAcceptedAt(updated.getAcceptedAt());
        challenge.setDeclinedAt(updated.getDeclinedAt());
        challenge.setCancelledAt(updated.getCancelledAt());
        challenge.setUpdatedAt(updated.getUpdatedAt());

        return this.repository.save(challenge);
    }

    @Override
    public void deleteChallengeById(Long id) {
        this.repository.deleteById(id);
    }
}
