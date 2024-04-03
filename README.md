# Arcane Arithmetic

## Description

Arcane Arithmetic is a game that my group members and I made for our CS 2212B course at UWO. We used JavaFX to make the game logic, a combination of CSS and JavaFX's Scene Builder for the GUI, and Python for the database. This game is aimed at grade 12 students as a way to help teach them about math topics. The game features 3 subjects: Calculus, Introductory Statistics, and Algebra. Each subject features questions at 3 levels: easy, medium, and hard. It also supports 3 question types: Fill-in-the-Blank, Mutiple Choice, and Matching.

[Here's a link to a youtube video that demonstrates our project capabilities](https://youtu.be/uI_yE-1682g) 

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

## Deleting all users from database

- Open users.json and ranks.json files (located in python/DatabaseFiles or [here](DatabaseFiles)
- Delete every entry in both files

## Contributors 

- **Candice Williams** (Group Leader) - Contributed to the JavaFX and CSS styling of the project. Facilitated the majority of the planning and organization throughout this projects execution.
- **Arian Firoozfar** - Created the database including all the databse functionality. To read the full API documentation go to Docs/API/API_Final.md or click [here](API_Final.md).
- **Ming Chun Chan** - Main contributor to the GUI of the application through the use of CSS and FXML. Also contributed heavily to the JavaFX logic.
- **Jamie Muha** - Created the JSON files used in the database. Researched the majority of the questions used in the project and confirmed their validity.
- **Justin Xu** - contributed heavily to the linking of the Java client server and the Python database. Contributed to the JavaFX.
