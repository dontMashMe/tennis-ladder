package io.github.dontmashme.tennisladder.dto.ladder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/*
    "name": "Spring 2026 Ladder",
    "description": "Local club spring ladder",
    "status": "active",
    "startsOn": "2026-05-16",
    "endsOn": "2026-08-31"
  }
  */
public class CreateLadderRequest {
    private String name;
    private String description;
    private String status;
    private OffsetDateTime startsOn;
    private OffsetDateTime endsOn;
}
