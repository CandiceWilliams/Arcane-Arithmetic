# test_FillInTheBlank.py
import unittest
from FillInTheBlank import FillInTheBlank

class TestFillInTheBlank(unittest.TestCase):
    def test_to_serializable(self):
        question = "The Eiffel Tower is located in _."
        answer = "Paris"
        question_id = 2
        difficulty = "Medium"
        subject = "Geography"

        fitb = FillInTheBlank(question, answer, question_id, difficulty, subject)
        result = fitb.to_serializable()

        expected = {
            "question": question,
            "answer": answer,
            "difficulty": difficulty.strip(),
            "question_id": question_id,
            "subject": subject
        }

        self.assertEqual(result, expected)

if __name__ == '__main__':
    unittest.main()
