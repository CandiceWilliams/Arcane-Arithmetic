# test_MCQuestions.py
import unittest
from MCQuestions import MCQuestions

class TestMCQuestions(unittest.TestCase):
    def test_to_serializable(self):
        question = "What is the capital of France?"
        answer = "Paris"
        question_id = 1
        difficulty = "Easy"
        subject = "Geography"
        options = ["Paris", "Rome", "Madrid", "Berlin"]

        mcq = MCQuestions(question, answer, question_id, difficulty, subject, options)
        result = mcq.to_serializable()

        expected = {
            "question": question,
            "answer": answer,
            "difficulty": difficulty,
            "question_id": question_id,
            "subject": subject,
            "options": options
        }

        self.assertEqual(result, expected)

if __name__ == '__main__':
    unittest.main()
