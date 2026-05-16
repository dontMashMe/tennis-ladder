package io.github.dontmashme.tennisladder.service.player;

import io.github.dontmashme.tennisladder.dto.player.CreatePlayerRequest;
import io.github.dontmashme.tennisladder.dto.player.UpdatePlayerRequest;
import io.github.dontmashme.tennisladder.entity.PlayerEntity;

import java.util.List;

public interface PlayerService {
    PlayerEntity savePlayer(CreatePlayerRequest player);
    List<PlayerEntity> fetchAllPlayers();
    PlayerEntity fetchPlayer(Long id);
    PlayerEntity updatePlayer(Long id, UpdatePlayerRequest updated);
    void deletePlayerById(Long id);
}
