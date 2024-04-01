from flask_testing import TestCase
from API import app
import json

class TestAPI(TestCase):
    def create_app(self):
        app.config['TESTING'] = True
        return app

    def test_insert_user(self):
        # Assuming your insertUser route expects a query parameter "data" with user info
        data = {
            "username": "testUser",
            "password": "testPass",
            "name": "Test Name",
            "privilege": "user"
        }
        response = self.client.get('/database/users/insert', query_string={'data': json.dumps(data)})
        self.assertEqual(response.status_code, 200)
        
        # Parse response data
        response_data = json.loads(response.data.decode('utf-8'))
        
        # Assert on the response content if necessary
        # Example: self.assertEqual(response_data['username'], data['username'])

if __name__ == '__main__':
    import unittest
    unittest.main()
