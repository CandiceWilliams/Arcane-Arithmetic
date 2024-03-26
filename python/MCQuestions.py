
import json
import random

class MCQuestions: 

    questions = []

    def __init__(self, question, answer, question_id, difficulty, subject, options):
        self.question = question
        self.answer = answer
        self.question_id = question_id
        self.difficulty = difficulty
        self.subject = subject
        self.options = options 
        MCQuestions.questions.append(self)



    def parseJsonFile() :
        with open("MCQuestions.json", 'r') as file:
            data = json.load(file)


        for obj in data:
            MCQuestions(obj["question"], obj["answer"], obj["question_id"], obj["difficulty"], obj["subject"], obj["options"])



    # Returns the question with the given ID
    def getQuestionByID(id): 

        for i in MCQuestions.questions:
            if id == i.question_id :
                return i

        return None


    # Returns a random question with the given subject
    def getRandomQuestionBySubject(subject):
        Qs = []

        # Take all questions with the specified subject
        for i in MCQuestions.questions :
            if i.subject == subject:
                Qs.append(i)

        return random.choice(Qs)


    # Returns a random question with the given difficulty level
    def getRandomQuestionByDifficulty(difficulty): 
        Qs = []

        # Take all questions with the specified difficulty
        for i in MCQuestions.questions :
            if i.difficulty == difficulty:
                Qs.append(i)

        return random.choice(Qs)



MCQuestions.parseJsonFile()

print(MCQuestions.getRandomQuestionBySubject("algebra").question)
print("\n")
print(MCQuestions.getRandomQuestionByDifficulty("easy").question)
