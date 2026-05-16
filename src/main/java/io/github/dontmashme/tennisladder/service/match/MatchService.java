package io.github.dontmashme.tennisladder.service.match;

import io.github.dontmashme.tennisladder.entity.MatchEntity;

import java.util.List;

public interface MatchService {
    MatchEntity saveMatch(MatchEntity match);
    List<MatchEntity> fetchAllMatches();
    MatchEntity updateMatch(Long id, MatchEntity updated);
    void deleteMatchById(Long id);
}
