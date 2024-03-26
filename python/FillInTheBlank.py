import json
import random

class FillInTheBlank: 

    questions = []

    def __init__(self, question, answer, question_id, difficulty, subject):
        self.question = question
        self.answer = answer
        self.question_id = question_id
        self.difficulty = difficulty
        self.subject = subject
        self.questions.append(self)



    def parseJsonFile() :
        with open("FillInTheBlank.json", 'r') as file:
            data = json.load(file)


        for obj in data:
            FillInTheBlank(obj["question"], obj["answer"], obj["question_id"], obj["difficulty"], obj["subject"])



    # Returns the question with the given ID
    def getQuestionByID(id): 

        for i in FillInTheBlank.questions:
            if id == i.question_id :
                return i

        return None


    # Returns a random question with the given subject
    def getRandomQuestionBySubject(subject):
        Qs = []

        # Take all questions with the specified subject
        for i in FillInTheBlank.questions :
            if i.subject == subject:
                Qs.append(i)

        return random.choice(Qs)


    # Returns a random question with the given difficulty level
    def getRandomQuestionByDifficulty(difficulty): 
        Qs = []

        # Take all questions with the specified difficulty
        for i in FillInTheBlank.questions :
            if i.difficulty == difficulty:
                Qs.append(i)

        return random.choice(Qs)



FillInTheBlank.parseJsonFile()

print(FillInTheBlank.getRandomQuestionBySubject("algebra").question)
print("\n")
print(FillInTheBlank.getRandomQuestionByDifficulty("easy").question)







