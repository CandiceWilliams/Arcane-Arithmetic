import json
import random
import platform

system = platform.system()

class FillInTheBlank: 
    
    
    
    """
    Represents a collection of fill-in-the-blank questions with methods to handle them.
    """ 
    

    questions = []
    
    def to_serializable(self):
        return {
            "question": self.question,
            "answer": self.answer,
            "difficulty": self.difficulty.strip(),  # Removing any trailing spaces
            "question_id": self.question_id,
            "subject": self.subject
        }

    def __init__(self, question, answer, question_id, difficulty, subject):
        """
        Initializes a FillInTheBlank object with provided attributes.

        Args:
            question (str): The main question text.
            answer (str): The correct answer to the question.
            question_id (int): Identifier for the question.
            difficulty (str): Difficulty level of the question.
            subject (str): Subject category of the question.
        """
        self.question = question
        self.answer = answer
        self.question_id = question_id
        self.difficulty = difficulty
        self.subject = subject
        self.questions.append(self)


    def parseJsonFile():
        """
        Parses a JSON file containing fill-in-the-blank questions and populates the questions list.
        """

    def parseJsonFile() :
        """
        Parses a JSON file containing fill-in-the-blank questions and populates the questions list.
        """
        
        
        if system == "Windows":
            filedir = "DatabaseFiles\\FillInTheBlank.json"
        else:
            filedir = "DatabaseFiles/FillInTheBlank.json"
        
        with open(filedir, 'r') as file:
            data = json.load(file)


        for obj in data:
            FillInTheBlank(obj["question"], obj["answer"], obj["question_id"], obj["difficulty"], obj["subject"])



    # Returns the question with the given ID

    def getQuestionByID(id): 
            id (int): The ID of the question to retrieve.

        Returns:
            FillInTheBlank or None: The fill-in-the-blank question if found, None otherwise.
        """ 

        for i in FillInTheBlank.questions:
            if id == i.question_id :
                return i

        return None


    # Returns a random question with the given subject
    def getRandomQuestionBySubject(subject):
        """
        Returns a random fill-in-the-blank question with the given subject.

        Args:
            subject (str): The subject category of the question to retrieve.

        Returns:
            FillInTheBlank: A random fill-in-the-blank question with the specified subject.
        """
        Qs = []

        # Take all questions with the specified subject
        for i in FillInTheBlank.questions :
            if i.subject == subject:
                Qs.append(i)

        return random.choice(Qs)


    # Returns a random question with the given difficulty level
    def getRandomQuestionByDifficulty(difficulty): 
        """
        Returns a random fill-in-the-blank question with the given difficulty level.

        Args:
            difficulty (str): The difficulty level of the question to retrieve.

        Returns:
            FillInTheBlank: A random fill-in-the-blank question with the specified difficulty level.
        """
        Qs = []

        # Take all questions with the specified difficulty
        for i in FillInTheBlank.questions :
            if i.difficulty == difficulty:
                Qs.append(i)

        return random.choice(Qs)




