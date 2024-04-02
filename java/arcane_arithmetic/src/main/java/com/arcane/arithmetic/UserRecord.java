package com.arcane.arithmetic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class UserRecord {
    // variables used for calculations
    // "winning" a game = passing = getting more than 10 problems correct out of 20
    private int total_games_won, total_games_played; // to calculate average win rate
    private int total_correct_problems, total_incorrect_problems; // to calculate average amount of right and wrong answers

    // variables to be displayed in Instructor Dashboard
    private String username;
    private int total_points;
    private double average_win_rate = 0, average_right = 0, average_wrong = 0;

    // variable used for accessing the API
    private String userID;

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
    }
    public void setTotalGamesWon(int v){
        total_games_won = v;
        if (total_games_played > 0) average_win_rate = (double)total_games_won / total_games_played;
    }
    public void setTotalGamesPlayed(int v){
        total_games_played = v;
        if (total_games_played > 0) average_win_rate = (double)total_games_won / total_games_played;
    }
    public void setTotalCorrectProblems(int v){
        total_correct_problems = v;
        if (total_correct_problems + total_incorrect_problems > 0) {
            average_right = (double)total_correct_problems / (total_correct_problems + total_incorrect_problems);
            average_wrong = (double)total_incorrect_problems / (total_correct_problems + total_incorrect_problems);
        }
    }
    public void setTotalIncorrectProblems(int v){
        total_incorrect_problems = v;
        if (total_correct_problems + total_incorrect_problems > 0) {
            average_right = (double)total_correct_problems / (total_correct_problems + total_incorrect_problems);
            average_wrong = (double)total_incorrect_problems / (total_correct_problems + total_incorrect_problems);
        }
    }

    // Getter methods for Instructor Dashboard
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

    // extra getter methods for API
    public int getTotalGamesWon(){
        return total_games_won;
    }
    public int getTotalGamesPlayed(){
        return total_games_played;
    }
    public int getTotalCorrect(){
        return total_correct_problems;
    }
    public int getTotalIncorrect(){
        return total_incorrect_problems;
    }
    public String getUserID(){
        return userID;
    }

    public static String insertUserRecordIntoAPI(UserRecord userRecord) {
        String newUserRecord  = String.format("{\"totalPoints\": %d, \"totalWon\": %d, \"totalPlayed\": %d, \"totalCorrect\": %d, \"totalIncorrect\": %d, \"ownerID\": \"%s\"}",
                userRecord.getTotalPoints(), userRecord.getTotalGamesWon(), userRecord.getTotalGamesPlayed(), userRecord.getTotalCorrect(), userRecord.getTotalIncorrect(), userRecord.getUserID());
        try {
            String urlString = "http://127.0.0.1:5000/database/ranks/insert?data=";
            urlString += newUserRecord;
            urlString = urlString.replace(" ", "%20");
            // Send the request to the server
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connection
            in.close();
            con.disconnect();
            // Print the response
            System.out.println("Status for inserting user record with userID = " + userRecord.getUserID() + ": " + content.toString());
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String deleteUserRecordFromAPI(String userID){
        try {
            String urlString = "http://127.0.0.1:5000/database/ranks/delete?id=" + userID;
            // Send the request to the server
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connection
            in.close();
            con.disconnect();
            // Print the response
            System.out.println("Status for deleting userID = " + userID + ": " + content.toString());
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static UserRecord fetchUserRecordHelper(String userID){
        try {
            String urlString = "http://127.0.0.1:5000/database/ranks/get?id="+userID;
            // Send the request to the server
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connection
            in.close();
            con.disconnect();
            // Print the response
            JsonNode node = new ObjectMapper().readTree(content.toString());
            JsonNode testNode = node.get("totalPoints");
            if (testNode == null) { // content.toString() is an error message (i.e. the userID is invalid)
                System.out.println("user ID = " + userID + " does not exist in the user records database");
                return null;
            }
            int totalPoints = Integer.parseInt(node.get("totalPoints").toString());
            int totalWon = Integer.parseInt(node.get("totalWon").toString());
            int totalPlayed = Integer.parseInt(node.get("totalPlayed").toString());
            int totalCorrect = Integer.parseInt(node.get("totalCorrect").toString());
            int totalIncorrect = Integer.parseInt(node.get("totalIncorrect").toString());
            String username = getUsernameFromUserID(userID);
            if (username == null) { // userID is invalid (the userID doesn't exist in ranks.json)
                System.out.println("user ID = " + userID + " exists in the user records database, however, it is invalid because it doesn't exist in the users database");
                return null;
            }
            System.out.println("Successfully fetched userID = " + userID);
            return new UserRecord(userID, username, totalPoints, totalWon, totalPlayed, totalCorrect, totalIncorrect);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ObservableList<UserRecord> fetchAllUserRecordsFromAPI(){
        try {
            String urlString = "http://127.0.0.1:5000/database/ranks/getall";
            // Send the request to the server
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connection
            in.close();
            con.disconnect();
            // Print the response
            JsonNode arrNode = new ObjectMapper().readTree(content.toString());
            System.out.println("List of all user records: ");
            System.out.println(arrNode.toPrettyString());
            ObservableList<UserRecord> returnList = FXCollections.observableArrayList();
            for (final JsonNode node : arrNode) {
                int totalPoints = Integer.parseInt(node.get("totalPoints").toString());
                int totalWon = Integer.parseInt(node.get("totalWon").toString());
                int totalPlayed = Integer.parseInt(node.get("totalPlayed").toString());
                int totalCorrect = Integer.parseInt(node.get("totalCorrect").toString());
                int totalIncorrect = Integer.parseInt(node.get("totalIncorrect").toString());
                String userID = node.get("ownerID").toString();
                userID = userID.substring(1, userID.length()-1);
                String username = UserRecord.getUsernameFromUserID(userID);
                if (username == null) continue; // invalid user because user exists in user records database but not in user database
                UserRecord toAdd = new UserRecord(userID, username, totalPoints, totalWon, totalPlayed, totalCorrect, totalIncorrect);
                returnList.add(toAdd);
            }
            return returnList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsernameFromUserID(String userID){
        try {
            String urlString = "http://127.0.0.1:5000/database/users/get?id=" + userID;
            // Send the request to the server
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connection
            in.close();
            con.disconnect();
            // Print the response
            System.out.println("Status for fetching username from userID = " + userID + ": " + content.toString());
            JsonNode json = new ObjectMapper().readTree(content.toString());
            JsonNode tmpNode = json.get("username");
            if (tmpNode == null) return null;
            String tmp = tmpNode.toString();
            return tmp.substring(1, tmp.length()-1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // CALL THIS AT THE END OF A GAME LOOP FOR EACH USER INVOLVED (TO UPDATE THEIR USER RECORDS IN API)
    public static void updateUserRecordInAPI(String userID, UserRecord newRecord){
        UserRecord.deleteUserRecordFromAPI(userID);
        UserRecord.insertUserRecordIntoAPI(newRecord);
    }
}
