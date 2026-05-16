package io.github.dontmashme.tennisladder.dto.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlayerRequest {
    private String email;
    private String displayName;
}
