package io.github.dontmashme.tennisladder.service.setscore;

import io.github.dontmashme.tennisladder.entity.SetScoreEntity;
import io.github.dontmashme.tennisladder.repository.SetScoreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetScoreServiceImpl implements SetScoreService {
    private final SetScoreRepository repository;

    public SetScoreServiceImpl(SetScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public SetScoreEntity saveSetScore(SetScoreEntity setScore) {
        return this.repository.save(setScore);
    }

    @Override
    public List<SetScoreEntity> fetchAllSetScores() {
        return this.repository.findAll();
    }

    @Override
    public SetScoreEntity updateSetScore(Long id, SetScoreEntity updated) {
        var setScore = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Set score not found: " + id));

        setScore.setMatch(updated.getMatch());
        setScore.setSetNumber(updated.getSetNumber());
        setScore.setWinnerGames(updated.getWinnerGames());
        setScore.setLoserGames(updated.getLoserGames());
        setScore.setWinnerTiebreakPoints(updated.getWinnerTiebreakPoints());
        setScore.setLoserTiebreakPoints(updated.getLoserTiebreakPoints());

        return this.repository.save(setScore);
    }

    @Override
    public void deleteSetScoreById(Long id) {
        this.repository.deleteById(id);
    }
}
