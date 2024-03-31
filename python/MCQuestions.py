
import json
import random
import platform


system = platform.system()

class MCQuestions: 
    """
    Represents a collection of multiple-choice questions with methods to handle them.
    """

    questions = []
    
    def to_serializable(self):
        return {
            "question": self.question,
            "answer": self.answer,
            "difficulty": self.difficulty,
            "question_id": self.question_id,
            "subject": self.subject,
            "options": self.options
        }

    def __init__(self, question, answer, question_id, difficulty, subject, options):
        """
        Initializes a MCQuestions object with provided attributes.

        Args:
            question (str): The main question text.
            answer (str): The correct answer to the question.
            question_id (int): Identifier for the question.
            difficulty (str): Difficulty level of the question.
            subject (str): Subject category of the question.
            options (array of str): The list of options for the question.
        """
        self.question = question
        self.answer = answer
        self.question_id = question_id
        self.difficulty = difficulty
        self.subject = subject
        self.options = options 
        MCQuestions.questions.append(self)



    def parseJsonFile() :
        """
        Parses a JSON file containing multiple-choice questions and populates the questions list.
        """
        if system == "Windows":
            filedir = "DatabaseFiles\\MCQuestions.json"
        else:
            filedir = "DatabaseFiles/MCQuestions.json"
        
        with open(filedir, 'r') as file:
            data = json.load(file)


        for obj in data:
            MCQuestions(obj["question"], obj["answer"], obj["question_id"], obj["difficulty"], obj["subject"], obj["options"])



    # Returns the question with the given ID
    def getQuestionByID(id): 
        """
        Returns the question with the given ID.

        Args:
            id (int): The ID of the question to retrieve.

        Returns:
            MCQuestions or None: The multiple-choice question if found, None otherwise.
        """

        for i in MCQuestions.questions:
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
            MCQuestions: A random multiple-choice question with the specified subject.
        """
        Qs = []

        # Take all questions with the specified subject
        for i in MCQuestions.questions :
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
            MCQuestions: A random multiple-choice question with the specified difficulty level.
        """
        Qs = []

        # Take all questions with the specified difficulty
        for i in MCQuestions.questions :
            if i.difficulty == difficulty:
                Qs.append(i)

        return random.choice(Qs)



