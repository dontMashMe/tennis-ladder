create table players (
    id bigserial primary key,
    display_name varchar(120) not null,
    email varchar(255),
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),

    constraint players_display_name_not_blank check (length(trim(display_name)) > 0),
    constraint players_email_unique unique (email)
);

create table ladders (
    id bigserial primary key,
    name varchar(120) not null,
    description text,
    status varchar(30) not null default 'active',
    starts_on date,
    ends_on date,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),

    constraint ladders_name_not_blank check (length(trim(name)) > 0),
    constraint ladders_status_valid check (status in ('active', 'completed', 'archived')),
    constraint ladders_date_range_valid check (ends_on is null or starts_on is null or ends_on >= starts_on)
);

create table ladder_entries (
    id bigserial primary key,
    ladder_id bigint not null,
    player_id bigint not null,
    position integer not null,
    status varchar(30) not null default 'active',
    joined_at timestamptz not null default now(),
    left_at timestamptz,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),

    constraint ladder_entries_ladder_fk foreign key (ladder_id) references ladders (id) on delete cascade,
    constraint ladder_entries_player_fk foreign key (player_id) references players (id),
    constraint ladder_entries_position_positive check (position > 0),
    constraint ladder_entries_status_valid check (status in ('active', 'inactive', 'removed')),
    constraint ladder_entries_left_after_joined check (left_at is null or left_at >= joined_at),
    constraint ladder_entries_ladder_player_unique unique (ladder_id, player_id),
    constraint ladder_entries_ladder_position_unique unique (ladder_id, position)
);

create table challenges (
    id bigserial primary key,
    ladder_id bigint not null,
    challenger_entry_id bigint not null,
    challenged_entry_id bigint not null,
    status varchar(30) not null default 'pending',
    message text,
    expires_at timestamptz,
    accepted_at timestamptz,
    declined_at timestamptz,
    cancelled_at timestamptz,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),

    constraint challenges_ladder_fk foreign key (ladder_id) references ladders (id) on delete cascade,
    constraint challenges_challenger_entry_fk foreign key (challenger_entry_id) references ladder_entries (id),
    constraint challenges_challenged_entry_fk foreign key (challenged_entry_id) references ladder_entries (id),
    constraint challenges_distinct_players check (challenger_entry_id <> challenged_entry_id),
    constraint challenges_status_valid check (status in ('pending', 'accepted', 'declined', 'cancelled', 'expired', 'completed'))
);

create table matches (
    id bigserial primary key,
    ladder_id bigint not null,
    challenge_id bigint,
    winner_entry_id bigint not null,
    loser_entry_id bigint not null,
    played_on date not null,
    notes text,
    created_at timestamptz not null default now(),
    updated_at timestamptz not null default now(),

    constraint matches_ladder_fk foreign key (ladder_id) references ladders (id) on delete cascade,
    constraint matches_challenge_fk foreign key (challenge_id) references challenges (id),
    constraint matches_winner_entry_fk foreign key (winner_entry_id) references ladder_entries (id),
    constraint matches_loser_entry_fk foreign key (loser_entry_id) references ladder_entries (id),
    constraint matches_distinct_players check (winner_entry_id <> loser_entry_id),
    constraint matches_challenge_unique unique (challenge_id)
);

create table set_scores (
    id bigserial primary key,
    match_id bigint not null,
    set_number integer not null,
    winner_games integer not null,
    loser_games integer not null,
    winner_tiebreak_points integer,
    loser_tiebreak_points integer,

    constraint set_scores_match_fk foreign key (match_id) references matches (id) on delete cascade,
    constraint set_scores_set_number_positive check (set_number > 0),
    constraint set_scores_games_non_negative check (winner_games >= 0 and loser_games >= 0),
    constraint set_scores_tiebreak_non_negative check (
        (winner_tiebreak_points is null and loser_tiebreak_points is null)
        or (winner_tiebreak_points >= 0 and loser_tiebreak_points >= 0)
    ),
    constraint set_scores_match_set_unique unique (match_id, set_number)
);

create index ladder_entries_player_id_idx on ladder_entries (player_id);
create index challenges_ladder_status_idx on challenges (ladder_id, status);
create index challenges_challenger_entry_id_idx on challenges (challenger_entry_id);
create index challenges_challenged_entry_id_idx on challenges (challenged_entry_id);
create index matches_ladder_played_on_idx on matches (ladder_id, played_on desc);
create index matches_winner_entry_id_idx on matches (winner_entry_id);
create index matches_loser_entry_id_idx on matches (loser_entry_id);
