# Arcane Arithmetics
Arcane Arithmetics is a game for Grade 12 students to master math concepts like Calculus, Linear Algebra and Intro Stats in an enjoyable way.
## Required Libraries and Dependencies
- **JavaFX Controls**: Provides UI components for building the graphical interface.
  - Group ID: org.openjfx
  - Artifact ID: javafx-controls
  - Version: 20.0.1

- **Jackson Databind**: A high-performance JSON processor for Java.
  - Group ID: com.fasterxml.jackson.core
  - Artifact ID: jackson-databind
  - Version: 2.16.2

- **ControlsFX**: Provides additional controls and utilities for JavaFX applications.
  - Group ID: org.controlsfx
  - Artifact ID: controlsfx
  - Version: 11.1.2

- **JavaFX FXML**: Enables building UIs using FXML markup language.
  - Group ID: org.openjfx
  - Artifact ID: javafx-fxml
  - Version: 20.0.1

- **JavaFX Media**: Provides multimedia capabilities for JavaFX applications.
  - Group ID: org.openjfx
  - Artifact ID: javafx-media
  - Version: 20.0.1

- **FXGL**: A game development framework built on top of JavaFX.
  - Group ID: com.github.almasb
  - Artifact ID: fxgl
  - Version: 17.3

- **JUnit**: Legacy JUnit framework for testing Java applications.
  - Group ID: junit
  - Artifact ID: junit
  - Version: 4.13.2

## Build and Run
Before running the program, ensure you have python installed. Then, navigate to the python folder where the API.py is, you should run the following command to start the database server:
```pip3.9 install flask```
```python api.py```

To build and run the program, ensure you have Maven installed. Then, navigate to the project directory and run the following command: 
```mvn clean javafx:run```

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