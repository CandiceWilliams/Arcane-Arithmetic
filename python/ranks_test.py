# test_ranks.py
import unittest
from ranks import Record

class TestRecord(unittest.TestCase):
    def test_init(self):
        totalPoints = 100
        totalWon = 10
        totalPlayed = 20
        totalCorrect = 30
        totalIncorrect = 10
        ownerID = "user123"

        record = Record(totalPoints, totalWon, totalPlayed, totalCorrect, totalIncorrect, ownerID)

        self.assertEqual(record.totalPoints, totalPoints)
        self.assertEqual(record.totalWon, totalWon)
        self.assertEqual(record.totalPlayed, totalPlayed)
        self.assertEqual(record.totalCorrect, totalCorrect)
        self.assertEqual(record.totalIncorrect, totalIncorrect)
        self.assertEqual(record.ownerID, ownerID)

if __name__ == '__main__':
    unittest.main()
