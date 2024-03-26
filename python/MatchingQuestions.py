import json
import random

class MatchingQuestions:

    questions = []

    def __init__(self, question, row1, row2, answer, question_id, difficulty, subject):
        self.question = question
        self.row1 = row1
        self.row2 = row2
        self.answer = answer
        self.question_id = question_id
        self.difficulty = difficulty
        self.subject = subject


    def parseJsonFile() :
        with open("MatchingQuestions.json", 'r') as file:
            data = json.load(file)


        for obj in data:
            #print(obj)
            MatchingQuestions(obj["question"], obj["row1"], obj["row2"], obj["answer"], obj["question_id"], obj["difficulty"], obj["subject"])



    # Returns the question with the given ID
    def getQuestionByID(id): 

        for i in MatchingQuestions.questions:
            if id == i.question_id :
                return i

        return None

    # Returns a random question with the given subject
    def getRandomQuestionBySubject(subject):
        Qs = []

        # Take all questions with the specified subject
        for i in MatchingQuestions.questions :
            if i.subject == subject:
                Qs.append(i)

        return random.choice(Qs)


    # Returns a random question with the given difficulty level
    def getRandomQuestionByDifficulty(difficulty): 
        Qs = []

        # Take all questions with the specified difficulty
        for i in MatchingQuestions.questions :
            if i.difficulty == difficulty:
                Qs.append(i)

        return random.choice(Qs)


MatchingQuestions.parseJsonFile()

print(MatchingQuestions.getRandomQuestionBySubject("algebra").question)
print("\n")
print(MatchingQuestions.getRandomQuestionByDifficulty("easy").question)


