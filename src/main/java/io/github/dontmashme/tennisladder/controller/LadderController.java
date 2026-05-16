package io.github.dontmashme.tennisladder.controller;

import io.github.dontmashme.tennisladder.dto.ladder.CreateLadderRequest;
import io.github.dontmashme.tennisladder.entity.LadderEntity;
import io.github.dontmashme.tennisladder.service.ladder.LadderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ladder")
public class LadderController {

    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    // Create ladder
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LadderEntity add(@RequestBody CreateLadderRequest ladderRequest) {
        return ladderService.saveLadder(ladderRequest);
    }

}
