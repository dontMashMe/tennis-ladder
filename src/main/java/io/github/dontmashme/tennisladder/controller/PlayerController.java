package io.github.dontmashme.tennisladder.controller;

import io.github.dontmashme.tennisladder.dto.player.CreatePlayerRequest;
import io.github.dontmashme.tennisladder.dto.player.UpdatePlayerRequest;
import io.github.dontmashme.tennisladder.entity.PlayerEntity;
import io.github.dontmashme.tennisladder.service.player.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerEntity> getPlayers() {
        return playerService.fetchAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerEntity getPlayer(@PathVariable Long id) {
        return playerService.fetchPlayer(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerEntity add(@RequestBody CreatePlayerRequest playerRequest) {
        return playerService.savePlayer(playerRequest);
    }

    @PutMapping("/{id}")
    public PlayerEntity updatePlayer(@PathVariable Long id, @RequestBody UpdatePlayerRequest playerRequest) {
        return playerService.updatePlayer(id, playerRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayerById(id);
    }
}
