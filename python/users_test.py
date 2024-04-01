# test_users.py
import unittest
from users import User

class TestUser(unittest.TestCase):
    def test_init(self):
        username = "johndoe"
        password = "password123"
        name = "John Doe"
        privilege = "user"
        user = User(username, password, name, privilege)

        self.assertEqual(user.username, username)
        self.assertEqual(user.password, password)
        self.assertEqual(user.name, name)
        self.assertEqual(user.privilege, privilege)

if __name__ == '__main__':
    unittest.main()
