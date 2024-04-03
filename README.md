# Arcane Arithmetics
Arcane Arithmetics is a game for Grade 12 students to master math concepts like Calculus, Linear Algebra and Intro Stats in an enjoyable way.
## Required Libraries and Dependencies
- **Apache Maven**: Required to build and run the program
  - Version: 3.11.0
- **Flask**: Required to run the API database
  - Version: 3.0.2
  - To install flask, run this command:
    - ```pip3.9 install flask```
  - API Documentation is located at ../Docs/API
- **JavaFX**: Dependency used to create GUI
  - Version: 20.0.1
## Build and Run
To build and run the program, ensure you have Maven installed and api.py running. Then, navigate to the project directory and run the following command: 
```mvn clean javafx:run```

An easier way to run the program (For this, you only need Python and a JRE installed): First, run API.py (e.g. typing "python API.py" in the python folder), then double clicking on the jar file called "Arcane Arithmetic"

## User Guide
- **Start**
  - Sign-up for a new account or sign-in if you already have one
  - Choose a topic
  - Choose a difficulty
  - Enjoy the game
- **Leaderboard**
  - Press load table to load the leaderboard
- **Settings**
  - Enable or disable audio and music
  - Maximize or unmaximize the game

## Instructor Dashboard

- Open settings menu
- Press Instructor Dashboard
- Authentication password: xyz369
- Press load table

## Cheats Mode

- Open settings menu
- Press Cheats Mode
- Password: hamburger123

# Deleting all users from database

- Open users.json and ranks.json files (located in python/DatabaseFiles)
- Delete every entry in both files