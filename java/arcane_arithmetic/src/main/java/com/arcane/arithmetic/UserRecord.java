package com.arcane.arithmetic;

import java.util.Objects;

public class UserRecord {
    // variables used for calculations
    private int total_games_won, total_games_played; // to calculate average win rate
    private int total_correct_problems, total_incorrect_problems; // to calculate average amount of right and wrong answers

    // variables to be displayed in Instructor Dashboard
    private String username;
    private int total_points;
    private double average_win_rate, average_right, average_wrong;

    // variable used for accessing the API
    private String userID;

    public UserRecord(){
        setUserID("");
        setUsername("");
        setTotalPoints(0);
        setTotalGamesWon(0);
        setTotalGamesPlayed(0);
        setTotalCorrectProblems(0);
        setTotalIncorrectProblems(0);
    }

    public UserRecord(String userID, String username, int total_points, int total_games_won, int total_games_played, int totalCorrectProblems, int totalIncorrectProblems){
        setUserID(userID);
        setUsername(username);
        setTotalPoints(total_points);
        setTotalGamesWon(total_games_won);
        setTotalGamesPlayed(total_games_played);
        setTotalCorrectProblems(totalCorrectProblems);
        setTotalIncorrectProblems(totalIncorrectProblems);
    }

    // setter and getter methods for instructor dashboard variables
    public void setUserID(String userID){
        this.userID = userID;
    }
    public void setUsername(String str){
        username = str;
    }
    public void setTotalPoints(int v){
        total_points = v;
        // TODO: update total points in database
    }
    public void setTotalGamesWon(int v){
        total_games_won = v;
        if (total_games_played > 0) average_win_rate = (double)total_games_won / total_games_played;
        // TODO: update total games won in database
    }
    public void setTotalGamesPlayed(int v){
        total_games_played = v;
        if (total_games_played > 0) average_win_rate = (double)total_games_won / total_games_played;
        // TODO: update total games played in database
    }
    public void setTotalCorrectProblems(int v){
        total_correct_problems = v;
        if (total_correct_problems + total_incorrect_problems > 0) {
            average_right = (double)total_correct_problems / (total_correct_problems + total_incorrect_problems);
            average_wrong = (double)total_incorrect_problems / (total_correct_problems + total_incorrect_problems);
        }
        // TODO: update total correct problems in database
    }
    public void setTotalIncorrectProblems(int v){
        total_incorrect_problems = v;
        if (total_correct_problems + total_incorrect_problems > 0) {
            average_right = (double)total_correct_problems / (total_correct_problems + total_incorrect_problems);
            average_wrong = (double)total_incorrect_problems / (total_correct_problems + total_incorrect_problems);
        }
        // TODO: update total incorrect problems in database
    }
    public String getUserID(){
        return userID;
    }
    public String getUsername(){ // used in Instructor Dashboard
        return username;
    }
    public int getTotalPoints(){ // used in Instructor Dashboard
        return total_points;
    }
    public double getAverageWinRate(){ // used in Instructor Dashboard
        return average_win_rate;
    }
    public double getAverageRight(){ // used in Instructor Dashboard
        return average_right;
    }
    public double getAverageWrong(){ // used in Instructor Dashboard
        return average_wrong;
    }
}
