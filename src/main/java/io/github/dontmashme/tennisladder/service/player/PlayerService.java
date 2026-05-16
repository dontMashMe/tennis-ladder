package io.github.dontmashme.tennisladder.service.player;

import io.github.dontmashme.tennisladder.entity.PlayerEntity;

import java.util.List;

public interface PlayerService {
    PlayerEntity savePlayer(PlayerEntity player);
    List<PlayerEntity> fetchAllPlayers();
    PlayerEntity updatePlayer(Long id, PlayerEntity updated);
    void deletePlayerById(Long id);
}
