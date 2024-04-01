import unittest
from MatchingQuestions import MatchingQuestions

class TestMatchingQuestions(unittest.TestCase):

    def test_to_serializable(self):
        # Given
        question = "Match the capitals to their countries."
        row1 = {"A": "USA", "B": "France"}
        row2 = {"1": "Washington, D.C.", "2": "Paris"}
        answer = ["A1", "B2"]
        question_id = 1
        difficulty = "Easy"
        subject = "Geography"

        # When
        matching_question = MatchingQuestions(question, row1, row2, answer, question_id, difficulty, subject)
        result = matching_question.to_serializable()

        # Then
        expected = {
            "question": question,
            "row1": row1,
            "row2": row2,
            "answer": answer,
            "difficulty": difficulty,
            "subject": subject,
            "question_id": question_id
        }
        self.assertEqual(result, expected)

if __name__ == '__main__':
    unittest.main()
