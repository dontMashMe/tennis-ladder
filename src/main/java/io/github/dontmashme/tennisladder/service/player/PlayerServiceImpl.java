package io.github.dontmashme.tennisladder.service.player;

import io.github.dontmashme.tennisladder.dto.player.CreatePlayerRequest;
import io.github.dontmashme.tennisladder.dto.player.UpdatePlayerRequest;
import io.github.dontmashme.tennisladder.entity.PlayerEntity;
import io.github.dontmashme.tennisladder.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;

    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlayerEntity fetchPlayer(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found: " + id));
    }

    @Override
    public PlayerEntity savePlayer(CreatePlayerRequest playerRequest) {
        var entity = new PlayerEntity();
        entity.setDisplayName(playerRequest.getDisplayName());
        entity.setEmail(playerRequest.getEmail());
        entity.setCreatedAt(OffsetDateTime.now());
        entity.setUpdatedAt(OffsetDateTime.now());
        return this.repository.save(entity);
    }

    @Override
    public List<PlayerEntity> fetchAllPlayers() {
        return this.repository.findAll();
    }

    @Override
    public PlayerEntity updatePlayer(Long id, UpdatePlayerRequest updated) {
        var player = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found: " + id));

        player.setUpdatedAt(OffsetDateTime.now());
        player.setEmail(updated.getEmail());
        player.setDisplayName(updated.getDisplayName());

        return this.repository.save(player);
    }

    @Override
    public void deletePlayerById(Long id) {
        this.repository.deleteById(id);
    }
}
