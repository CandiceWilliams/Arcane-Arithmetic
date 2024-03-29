import json
import random

class MatchingQuestions:
    """
    Represents a collection of matching questions with methods to handle them.
    """
    questions = []

    def __init__(self, question, row1, row2, answer, question_id, difficulty, subject):
        """
        Initializes a MatchingQuestions object with provided attributes.

        Args:
            question (str): The main question text.
            row1 (dict): Text for the first row.
            row2 (dict): Text for the second row.
            answer (array): The correct answer.
            question_id (int): Identifier for the question.
            difficulty (str): Difficulty level of the question.
            subject (str): Subject category of the question.
        """

        self.question = question
        self.row1 = row1
        self.row2 = row2
        self.answer = answer
        self.question_id = question_id
        self.difficulty = difficulty
        self.subject = subject

        MatchingQuestions.questions.append(self)

    
    def parseJsonFile() :
        """
        Parses a JSON file containing matching questions and populates the questions list.
        """
        with open("MatchingQuestions.json", 'r') as file:
            data = json.load(file)


        for obj in data:
            MatchingQuestions(obj["question"], obj["row1"], obj["row2"], obj["answer"], obj["question_id"], obj["difficulty"], obj["subject"])

        
    # Returns the question with the given ID
    def getQuestionByID(id): 
        """
        Returns the question with the given ID.

        Args:
            id (int): The ID of the question to retrieve.

        Returns:
            MatchingQuestions or None: The matching question if found, None otherwise.
        """

        for i in MatchingQuestions.questions:
            if id == i.question_id :
                return i

        return None

    # Returns a random question with the given subject
    def getRandomQuestionBySubject(subject):
        """
        Returns a random question with the given subject.

        Args:
            subject (str): The subject category of the question to retrieve.

        Returns:
            MatchingQuestions: A random matching question with the specified subject.
        """

        Qs = []

        # Take all questions with the specified subject
        for i in MatchingQuestions.questions :
            if i.subject == subject:
                Qs.append(i)

        return random.choice(Qs)


    # Returns a random question with the given difficulty level
    def getRandomQuestionByDifficulty(difficulty): 
        """
        Returns a random question with the given difficulty level.

        Args:
            difficulty (str): The difficulty level of the question to retrieve.

        Returns:
            MatchingQuestions: A random matching question with the specified difficulty level.
        """
        Qs = []

        # Take all questions with the specified difficulty
        for i in MatchingQuestions.questions :
            if i.difficulty == difficulty:
                Qs.append(i)

        return random.choice(Qs)


MatchingQuestions.parseJsonFile()

a = MatchingQuestions.getRandomQuestionBySubject("algebra")
print(a.question)
print(a.row1)
print(a.row2)


