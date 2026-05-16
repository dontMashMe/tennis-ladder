package io.github.dontmashme.tennisladder.service.ladder;

import io.github.dontmashme.tennisladder.entity.LadderEntity;
import io.github.dontmashme.tennisladder.repository.LadderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class LadderServiceImpl implements LadderService {
    private final LadderRepository repository;

    public LadderServiceImpl(LadderRepository repository) {
        this.repository = repository;
    }

    @Override
    public LadderEntity saveLadder(LadderEntity ladder) {
        return this.repository.save(ladder);
    }

    @Override
    public List<LadderEntity> fetchAllLadders() {
        return this.repository.findAll();
    }

    @Override
    public LadderEntity updateLadder(Long id, LadderEntity updated) {
        var ladder = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ladder not found: " + id));

        ladder.setName(updated.getName());
        ladder.setDescription(updated.getDescription());
        ladder.setStatus(updated.getStatus());
        ladder.setStartsOn(updated.getStartsOn());
        ladder.setEndsOn(updated.getEndsOn());
        ladder.setUpdatedAt(OffsetDateTime.now());

        return this.repository.save(ladder);
    }

    @Override
    public void deleteLadderById(Long id) {
        this.repository.deleteById(id);
    }
}
