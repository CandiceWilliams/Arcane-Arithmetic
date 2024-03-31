# Examples 

### Inserting a new user:

- Used for sign-up


```java
/*
This example shows how an HTTP request is made in Java. 
All possible actions in the API  can be done using this function but each URL path performs a different action
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
/*  {
        "username": string,
        "password": string, 
        "name": string, 
        "privilege": string
    }
*/
    public static void main(String[] args) {

        // define a new user as a json object
        String newUser  = "{\"username\": \"abcd\", \"password\": \"1234\", \"name\": \"testName\", \"privilege\": \"admin\"}";

        try {
            // Define the URL with the parameter
            String urlString = "http://127.0.0.1:5000/database/users/insert?data=";
            // Put the new user object as the value of the data parameter in the URL
            urlString += newUser;


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
            System.out.println(content.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

- There are four possible outputs for this program: 

    - ***Input Error*** : occurs when the data parameter is an invalid json object :
    ```json
    {
        "Error" : "Invalid Input"
    }
    ```
    - ***Duplication Error*** : occurs when the user already exists in the database :
    ```json
    {
        "Error": "User already exists"
    }
    ```
    - ***Parameter Error*** : Occurs when the URL parameter 'data' is empty :
    ```json
    {
        "Error": "No field specified"
    }
    ```
    - **Successful Insertion** Occurs when there is no error and the user was inserted into the database successfully. In this case the response is a json object with the information of the new user including their unique ID
    ```json
    {
        "username": "abcd",
        "password": "1234",
        "id": "WWlsaI9fYu",
        "name": "testName",
        "privilege": "admin"
    }
    ```

    ### Fetching a user

    - can be attained either by unique ID or username



```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
            // Define the URL with the parameter
            // Getting by ID
            String urlString = "http://127.0.0.1:5000/database/users/get?id=WWlsaI9fYu";

            // Getting by username
            //String urlString = "http://127.0.0.1:5000/database/users/get?username=abcd";



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
            System.out.println(content.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

- There are three possible responses for this request

    - **User doesn't exist** : In this case the following error is returned

    ```json
    {
        "Error": "User Not Found"
    }
    ```

    - **No URL parameter specified**: Occurs when the URL parameter (username or id) is empty

    ```json
    {
        "Error": "No field specified"
    }
    ```

    - **Successful request**: returns the user with the requested ID or username

    ```json
    {
        "username": "abcd",
        "password": "1234",
        "id": "WWlsaI9fYu",
        "name": "testName",
        "privilege": "admin"
    }
    ```

    ## Questions Database:

    - you can use the same function used in the previous examples to access the questions, except the URL has a different path


    - **Questions URL** : http://127.0.0.1:5000/database/questions/get


    - **To get a random question with a specific subject send the request to the following URLs** :

    ```
    http://127.0.0.1:5000/database/questions/get?subject=algebra&type=mc

    http://127.0.0.1:5000/database/questions/get?subject=calculus&type=matching

    http://127.0.0.1:5000/database/questions/get?subject=statistics&type=fb

    ```

    - **To get a random question with a specific difficulty send the reuqest to the following URLs**: 

    ```
    http://127.0.0.1:5000/database/questions/get?difficulty=easy&type=mc

    http://127.0.0.1:5000/database/questions/get?difficulty=medium&type=matching

    http://127.0.0.1:5000/database/questions/get?difficulty=difficult&type=fb

    ```

    - **To get a question with a specific subject and difficulty**:
    ```
    http://127.0.0.1:5000/database/questions/get?subject=calculus&difficulty=easy&type=mc
    ```

    **Make sure to specify the type of the question**:
        - Matching : matching
        - Multiple choice : mc
        - Fill in the blanks: fb

    - The API has three possible responses for the above URLs: 
        
        - ***The value of type is wrong***
        ```json
        {"Error": "Invalid Argument 'type'"}
        ```

        - ***The value of type is missing***
        ```json 
        {"Error": "Missing Argument 'type'"}
        ```

        - ***Successful Response**: returns a question with the requested properties

        ```json
        // Fill in the blank
        {
            "question": "In statistics, the __________ is the most frequently occurring value in a dataset.",
            "answer": "mode ",
            "difficulty": "easy ",
            "question_id": 20,
            "subject": "algebra"
        }
        ```

        ```json
        // Matching
        {
            "question": "Match the statistical terms with their definitions:",
            "row1": {
                "a": "Mean",
                "b": " Median",
                "c": "Mode",
                "d": "Range",
                "e": "Standard Deviation"
            },
            "row2": {
                "1": "The middle value of a dataset when arranged in ascending order.",
                "2": "The measure of the spread of values in a dataset around the mean.",
                "3": "The value that occurs most frequently in a dataset.",
                "4": "The arithmetic average of a set of values.",
                "5": "The difference between the maximum and minimum values in a dataset."
            },
            "answer": [
                [
                    "a",
                    4
                ],
                [
                    "b",
                    1
                ],
                [
                    "c",
                    3
                ],
                [
                    "d",
                    2
                ],
                [
                    "e",
                    5
                ]
            ],
            "difficulty": "easy",
            "subject": "statistics",
            "question_id": 1
        }
        ```

        ```json
        // Multiple choice
        {
            "question": "In a survey conducted among 500 students about their favorite sport, the following results were obtained: 180 students prefer basketball, 120 students prefer soccer, 100 students prefer tennis, 60 students prefer volleyball, 40 students prefer cricket. What percent of students preferred soccer?",
            "answer": "a) 24",
            "difficulty": "easy",
            "question_id": 1,
            "options": [
                "a) 24",
                "b) 30",
                "c) 20",
                "d) 12"
            ],
            "subject": "statistics "
        }
        ```

#### You can also get a question by its ID


```
http://127.0.0.1:5000/database/questions/get?id=5&type=mc
```

- The API returns an error if the ID is invalid or doesn't exist

```json
{"Error": "Question Not Found"}
```


# Ranks

## To insert a new rank: 

- structure of the data parameter: 
```json
{
    "totalPoints": 10,
    "totalWon": 14,
    "totalPlayed": 24,
    "totalCorrect": 20,
    "totalIncorrect": 4,
    "ownerID": "the user id who owns this record"
}

```
- Example URL
```
127.0.0.1:5000/database/ranks/insert?data={"totalPoints": 10, "totalWon": 14, "totalPlayed": 24, "totalCorrect": 20, "totalIncorrect": 4, "ownerID": "the user id who owns this record"}
```

- **you can use this URL to update an existing record by reinserting it**

## To get the rank of a user by user ID:

```
127.0.0.1:5000/database/ranks/get?id=userID
```

- Example return value :

```json
    {
        "totalPoints": 10,
        "totalWon": 20,
        "totalPlayed": 30,
        "totalCorrect": 40,
        "totalIncorrect": 2,
        "ownerID": "sss"
    }
```

- If there is no record with the specified ID
```json
{"Error": "Record not found"}
```

## To delete a rank by user ID

```
127.0.0.1:5000/database/ranks/delete?id=userID
```
- Returns "ok" if successful 


## To get all records

```
127.0.0.1:5000/database/ranks/getall
```

- Example output: 
```json
[
    {
        "totalPoints": 10,
        "totalWon": 10,
        "totalPlayed": 10,
        "totalCorrect": 10,
        "totalIncorrect": 10,
        "ownerID": "8nwwEYXxEF"
    },
    {
        "totalPoints": 10,
        "totalWon": 20,
        "totalPlayed": 30,
        "totalCorrect": 40,
        "totalIncorrect": 2,
        "ownerID": "sss"
    }
]
```
