package io.github.dontmashme.tennisladder.service.ladderentry;

import io.github.dontmashme.tennisladder.entity.LadderEntryEntity;
import io.github.dontmashme.tennisladder.repository.LadderEntryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class LadderEntryServiceImpl implements LadderEntryService {
    private final LadderEntryRepository repository;

    public LadderEntryServiceImpl(LadderEntryRepository repository) {
        this.repository = repository;
    }

    @Override
    public LadderEntryEntity saveLadderEntry(LadderEntryEntity ladderEntry) {
        return this.repository.save(ladderEntry);
    }

    @Override
    public List<LadderEntryEntity> fetchAllLadderEntries() {
        return this.repository.findAll();
    }

    @Override
    public LadderEntryEntity updateLadderEntry(Long id, LadderEntryEntity updated) {
        var ladderEntry = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ladder entry not found: " + id));

        ladderEntry.setLadder(updated.getLadder());
        ladderEntry.setPlayer(updated.getPlayer());
        ladderEntry.setPosition(updated.getPosition());
        ladderEntry.setStatus(updated.getStatus());
        ladderEntry.setJoinedAt(updated.getJoinedAt());
        ladderEntry.setLeftAt(updated.getLeftAt());
        ladderEntry.setUpdatedAt(OffsetDateTime.now());

        return this.repository.save(ladderEntry);
    }

    @Override
    public void deleteLadderEntryById(Long id) {
        this.repository.deleteById(id);
    }
}
