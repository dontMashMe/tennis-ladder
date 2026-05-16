package io.github.dontmashme.tennisladder.service.ladderentry;

import io.github.dontmashme.tennisladder.dto.ladderentry.CreateLadderEntryRequest;
import io.github.dontmashme.tennisladder.entity.LadderEntryEntity;
import io.github.dontmashme.tennisladder.repository.LadderRepository;
import io.github.dontmashme.tennisladder.repository.LadderEntryRepository;
import io.github.dontmashme.tennisladder.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class LadderEntryServiceImpl implements LadderEntryService {
    private final LadderEntryRepository ladderEntryRepository;
    private final LadderRepository ladderRepository;
    private final PlayerRepository playerRepository;

    public LadderEntryServiceImpl(
            LadderEntryRepository ladderEntryRepository,
            LadderRepository ladderRepository,
            PlayerRepository playerRepository
    ) {
        this.ladderEntryRepository = ladderEntryRepository;
        this.ladderRepository = ladderRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public LadderEntryEntity saveLadderEntry(CreateLadderEntryRequest request) {
        var ladder = this.ladderRepository.findById(request.getLadderId())
                .orElseThrow(() -> new EntityNotFoundException("Ladder not found: " + request.getLadderId()));
        var player = this.playerRepository.findById(request.getPlayerId())
                .orElseThrow(() -> new EntityNotFoundException("Player not found: " + request.getPlayerId()));
        var now = OffsetDateTime.now();

        var ladderEntry = new LadderEntryEntity();
        ladderEntry.setLadder(ladder);
        ladderEntry.setPlayer(player);
        ladderEntry.setPosition(request.getPosition());
        ladderEntry.setStatus(request.getStatus());
        ladderEntry.setJoinedAt(now);
        ladderEntry.setCreatedAt(now);
        ladderEntry.setUpdatedAt(now);

        return this.ladderEntryRepository.save(ladderEntry);
    }

    @Override
    public List<LadderEntryEntity> fetchAllLadderEntries() {
        return this.ladderEntryRepository.findAll();
    }

    @Override
    public LadderEntryEntity updateLadderEntry(Long id, LadderEntryEntity updated) {
        var ladderEntry = this.ladderEntryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ladder entry not found: " + id));

        ladderEntry.setLadder(updated.getLadder());
        ladderEntry.setPlayer(updated.getPlayer());
        ladderEntry.setPosition(updated.getPosition());
        ladderEntry.setStatus(updated.getStatus());
        ladderEntry.setJoinedAt(updated.getJoinedAt());
        ladderEntry.setLeftAt(updated.getLeftAt());
        ladderEntry.setUpdatedAt(OffsetDateTime.now());

        return this.ladderEntryRepository.save(ladderEntry);
    }

    @Override
    public void deleteLadderEntryById(Long id) {
        this.ladderEntryRepository.deleteById(id);
    }
}
