package io.github.dontmashme.tennisladder.dto.ladderentry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateLadderEntryRequest {
    private Long ladderId;
    private Long playerId;
    private Integer position;
    private String status;
}
