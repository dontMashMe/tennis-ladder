package io.github.dontmashme.tennisladder.service.player;

import io.github.dontmashme.tennisladder.entity.PlayerEntity;
import io.github.dontmashme.tennisladder.repository.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository repository;

    @Override
    public PlayerEntity savePlayer(PlayerEntity player) {
        return this.repository.save(player);
    }

    @Override
    public List<PlayerEntity> fetchAllPlayers() {
        return this.repository.findAll();
    }

    @Override
    public PlayerEntity updatePlayer(Long id, PlayerEntity updated) {
        var player = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found: " + id));

        player.setUpdatedAt(updated.getUpdatedAt());
        player.setEmail(updated.getEmail());
        player.setDisplayName(updated.getDisplayName());

        return this.repository.save(player);
    }

    @Override
    public void deletePlayerById(Long id) {
        this.repository.deleteById(id);
    }
}
