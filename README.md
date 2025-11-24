# FIFA Higher/Lower Game

A command-line card game using FIFA World Rankings data, where players guess whether countries are ranked higher or lower than each other.

## Quick Start

### Prerequisites
- Java 18 or higher
- Terminal/Command Line

### How to Run

**Option 1: From IntelliJ**
1. Open project in IntelliJ IDEA
2. Right-click on `Main.java`
3. Select "Run 'Main.main()'"

**Option 2: From Terminal**
```bash
cd src
javac com/game/**/*.java
java com.game.Main
```

## How to Play

1. The game shows you a country with its FIFA ranking
2. Guess if the next country is ranked **HIGHER** (better team, lower number) or **LOWER** (worse team, higher number)
3. Type `h` for HIGHER or `l` for LOWER
4. The game reveals the answer and updates your stats
5. Continue through all 52 countries in the deck

### Example
```
Current country - Spain (Rank #1)
Higher or Lower? (h/l): l

✓ CORRECT! It was: England (Rank #4)
```

**Remember:** HIGHER = better ranked team = smaller rank number!

## Game Features

- **52 Random Countries**: Each game selects 52 random countries from 210 available FIFA-ranked nations
- **Live Statistics**: Track accuracy, streaks, and score throughout gameplay
- **Streak Tracking**: Monitor your current and longest correct guess streaks
- **Final Summary**: View comprehensive statistics at game end

## Design Decisions

### Architecture

The project follows clean OOP principles with separation of concerns:
```
com.game/
├── model/          # Data models (Country, GameState, Guess)
├── data/           # Data loading (CountryData interface, CsvData implementation)
├── game/           # Game logic (HigherLowerGame engine)
├── cli/            # User interface (GameCli)
└── Main.java       # Entry point
```

### Key Design Patterns

**Interface-Based Data Source**
- `CountryData` interface allows multiple data source implementations
- Currently uses `CsvData` for reliability
- Architecture supports API integration in future

**State Management**
- `GameState` encapsulates all game statistics and deck management
- Clean separation between game logic and UI

**Enum for Type Safety**
- `Guess` enum (HIGHER/LOWER) prevents string-based bugs

### Why CSV Over API?

Initially designed with RapidAPI integration and fallback logic, pivoted to CSV-only for:

**Reliability**: Zero network dependencies during evaluation  
**Simplicity**: No API key management or rate limits  
**Speed**: Saved 1-2 hours of integration/debugging time  
**Professional**: Still demonstrates interface-based design thinking  

The architecture supports future API integration via the `CountryData` interface pattern.

## Data Source

FIFA World Rankings data (November 2025) sourced from official FIFA rankings, stored in `data/countries.csv` containing:
- 210 countries
- Current rank, points, and confederation
- Updated monthly by FIFA

## Project Structure
```
higher-lower/
├── README.md
├── DESIGN_DECISIONS.md     # Detailed design rationale
├── data/
│   └── countries.csv        # FIFA rankings data
└── src/
    └── com/game/
        ├── Main.java
        ├── model/
        │   ├── Country.java
        │   ├── GameState.java
        │   └── Guess.java
        ├── data/
        │   ├── CountryData.java
        │   └── CsvData.java
        ├── game/
        │   └── HigherLowerGame.java
        └── cli/
            └── GameCli.java
```

## Technical Highlights

- **Pure Java 18**: No external dependencies
- **Clean OOP**: Interface-based design, single responsibility principle
- **Robust Error Handling**: Graceful handling of file I/O and edge cases
- **Extensible**: Easy to add new data sources or game modes

## Future Enhancements

- API integration for live FIFA rankings
- Multiple game modes (e.g., guess exact rank, confederation-specific games)
- GUI implementation
- Leaderboard and score persistence
- Multiplayer support
