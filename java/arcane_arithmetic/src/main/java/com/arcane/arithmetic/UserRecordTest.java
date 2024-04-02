package com.arcane.arithmetic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javafx.collections.ObservableList;

public class UserRecordTest {

    @Test
    public void insertUser() throws JsonProcessingException {
        UserRecord userRecord = new UserRecord("8nwwEYXxEF", "testUser",10, 10, 10,10, 10);
        String ret = UserRecord.insertUserRecordIntoAPI(userRecord);
        JsonNode node = new ObjectMapper().readTree(ret.toString());
        String userID = node.get("ownerID").toString();
        int totalPoints = Integer.parseInt(node.get("totalPoints").toString());
        int totalWon = Integer.parseInt(node.get("totalWon").toString());
        int totalPlayed = Integer.parseInt(node.get("totalPlayed").toString());
        int totalCorrect = Integer.parseInt(node.get("totalCorrect").toString());
        int totalIncorrect = Integer.parseInt(node.get("totalIncorrect").toString());
        assertEquals(userID.substring(1,userID.length()-1), "8nwwEYXxEF");
        assertEquals(totalPoints, 10);
        assertEquals(totalWon, 10);
        assertEquals(totalPlayed, 10);
        assertEquals(totalCorrect, 10);
        assertEquals(totalIncorrect, 10);
    }

    @Test
    public void deleteUser() throws JsonProcessingException {
        insertUser();
        String userID = "junit_test_user_record";
        String ret = UserRecord.deleteUserRecordFromAPI(userID);
        assertNotNull(ret);
        assertEquals(ret, "ok");
    }

    @Test
    public void fetchUser() throws JsonProcessingException {
        insertUser();
        String userID = "8nwwEYXxEF";
        UserRecord cmp = UserRecord.fetchUserRecordHelper(userID);
        assertNotNull(userID);
        assertEquals(cmp.getUserID(), "8nwwEYXxEF");
        assertEquals(cmp.getTotalPoints(), 10);
        assertEquals(cmp.getTotalGamesWon(), 10);
        assertEquals(cmp.getTotalGamesPlayed(), 10);
        assertEquals(cmp.getTotalCorrect(), 10);
        assertEquals(cmp.getTotalIncorrect(), 10);
    }

    @Test
    public void fetchAllUsers() {
        ObservableList<UserRecord> list = UserRecord.fetchAllUserRecordsFromAPI();
        // non null -> list was successfully loaded from API
        // null -> error in loading list
        assertNotNull(list);
    }

    @Test
    public void getUsername() throws JsonProcessingException {
        insertUser();
        String ret = UserRecord.getUsernameFromUserID("8nwwEYXxEF");
        assertEquals(ret,"testUser");
    }
}