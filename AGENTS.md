# AGENTS.md

## Project Overview

Tennis Ladder is a lightweight web application for managing local tennis ladders and small tournaments.

The goal of the project is to provide a clean and mobile-friendly experience for:
- tracking player rankings
- issuing and managing challenges
- recording match results
- viewing ladder history and statistics

This is intentionally **not** an enterprise platform.
The focus is simplicity, maintainability, and good user experience for local communities and clubs.

---

# Tech Stack

## Backend
- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

## Frontend
- React
- TypeScript
- Vite
- Mobile-first responsive UI

---

# Architectural Principles

- Keep the domain model simple and explicit
- Prefer readability over abstraction
- Avoid premature optimization
- Avoid overengineering and enterprise patterns unless genuinely needed
- Favor small focused services over giant "god classes"
- REST-first backend
- Frontend should remain mostly dumb and API-driven

---

# Initial Core Domain

## Player
Represents a participant in the ladder.

## Ladder
Represents a single competition/season.

## LadderEntry
Represents a player's current ranking position inside a ladder.

## Challenge
Represents a challenge request between two players.

## Match
Represents a played tennis match and its result.

## SetScore
Represents individual set scores within a match.

---

# Initial Features

## MVP
- Create players
- Create ladder
- Join players to ladder
- View rankings
- Create challenge
- Accept/decline challenge
- Enter match result
- Automatically update rankings
- View match history

---

# Ranking Logic (Initial Version)

The ladder uses explicit positional ranking.

Example:
1. Player A
2. Player B
3. Player C

If a lower-ranked player defeats a higher-ranked player:
- the challenger takes the higher position
- affected players shift down

This is intentionally simple and understandable for local ladder play.

---

# Backend Package Structure

```text
com.tennisladder.player
com.tennisladder.ladder
com.tennisladder.challenge
com.tennisladder.match
com.tennisladder.shared
```

---

# Local Commands

When running tests from WSL with the Windows JDK configured at `/mnt/c/Java/jdk`, use the Windows Maven wrapper:

```bash
/mnt/c/Windows/System32/cmd.exe /c mvnw.cmd test
```

The Unix wrapper `./mvnw test` expects a Linux JDK at `$JAVA_HOME/bin/java` and will fail if `JAVA_HOME` points to a Windows JDK containing `java.exe`.
