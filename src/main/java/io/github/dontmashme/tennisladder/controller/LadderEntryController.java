package io.github.dontmashme.tennisladder.controller;

import io.github.dontmashme.tennisladder.dto.ladderentry.CreateLadderEntryRequest;
import io.github.dontmashme.tennisladder.entity.LadderEntryEntity;
import io.github.dontmashme.tennisladder.service.ladderentry.LadderEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ladder-entries")
public class LadderEntryController {
    private final LadderEntryService ladderEntryService;

    public LadderEntryController(LadderEntryService ladderEntryService) {
        this.ladderEntryService = ladderEntryService;
    }

    // Add to ladder
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LadderEntryEntity add(@RequestBody CreateLadderEntryRequest ladderEntryRequest) {
        return ladderEntryService.saveLadderEntry(ladderEntryRequest);
    }
}
