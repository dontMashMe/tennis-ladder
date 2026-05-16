package io.github.dontmashme.tennisladder.service.match;

import io.github.dontmashme.tennisladder.entity.MatchEntity;
import io.github.dontmashme.tennisladder.repository.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository repository;

    public MatchServiceImpl(MatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public MatchEntity saveMatch(MatchEntity match) {
        return this.repository.save(match);
    }

    @Override
    public List<MatchEntity> fetchAllMatches() {
        return this.repository.findAll();
    }

    @Override
    public MatchEntity updateMatch(Long id, MatchEntity updated) {
        var match = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found: " + id));

        match.setLadder(updated.getLadder());
        match.setChallenge(updated.getChallenge());
        match.setWinnerEntry(updated.getWinnerEntry());
        match.setLoserEntry(updated.getLoserEntry());
        match.setPlayedOn(updated.getPlayedOn());
        match.setNotes(updated.getNotes());
        match.setUpdatedAt(updated.getUpdatedAt());

        return this.repository.save(match);
    }

    @Override
    public void deleteMatchById(Long id) {
        this.repository.deleteById(id);
    }
}
