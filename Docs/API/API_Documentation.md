# API Documentation 

## /api/database

- **Path:** /api/database/__table_name__
- **Parameters:**
    - action: used to specify the action. Available values: insert, update, delete, fetch
    - access_token: the access token which allows the user to send requests to the API 
- **HTTP Methods**
    - Get: used for fetch
        - Response: 
            - Users
                ```json
                {
                    "id": "string",
                    "username": "string",
                    "password": "string",
                    "name": "string",
                    "privilege": "string"

                }
                ```

            - Saved Games
                ```json
                {
                "Session_id": "string",
                "Score": "int",
                "CurrentQuestionIndex": "int", 
                "Owner": "string", 
                }
                ```
            - Questions: 
                ```json
                {
                    "ID": "string",
                    "Question": "string",
                    "Answer": "string", 
                    "Topic": "string",
                    "Type": "string"
                }
                ```
    - Post: used for updating, inserting and deleting 
        ```json
        {
            "Errors": ["string"]
        }
        ``` 
- **API Endpoints**:
    - /api/database/users 
    - /api/database/savedgames
    - /api/database/questions

### Example
- Parameters: 

```
http://127.0.0.1/api/database/users?action=insert&access_token=abcd123
```

- Insertion: 

```bash
curl -X POST -H "Content-Type: application/json" -d '{"username": "abc", "password": "123456", "name": "aaaa", "privilege": "player"}' http://127.0.0.1/api/database/users?action=insert&access_token=abcd123
```