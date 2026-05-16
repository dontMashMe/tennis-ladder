package io.github.dontmashme.tennisladder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "set_scores",
        uniqueConstraints = @UniqueConstraint(name = "set_scores_match_set_unique", columnNames = {"match_id", "set_number"})
)
public class SetScoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    private MatchEntity match;

    @Column(name = "set_number", nullable = false)
    private Integer setNumber;

    @Column(name = "winner_games", nullable = false)
    private Integer winnerGames;

    @Column(name = "loser_games", nullable = false)
    private Integer loserGames;

    @Column(name = "winner_tiebreak_points")
    private Integer winnerTiebreakPoints;

    @Column(name = "loser_tiebreak_points")
    private Integer loserTiebreakPoints;
}
