# Objects for questions(one per json file)

- # FillInTheBlank.py 
    ### Properties
    - **Question** : string
    - **answer** : string
    - **difficulty** : string
    - **question_id** : int
    - **subject** : string
    - **Questions** (Static, global variable): a global variable in the class that stores all questions in an array

    ### Functions
    - **initializer**: this functions is the initialize method for the class. 
    
    - **parseJsonFile()** : This function opens the json file and converts all json objects to a python class

    - **getQuestionByID(id, type)** : returns the question with the specified ID and type

    - **getRandomQuestionBySubject(subject)** : returns a random question based on the specified subject and type

    - **getRandomQuestionByDifficulty(subject, type)** : returns a random question based on 


- # Matching.py

    ### Properties: 
    - **question** : string
    - **row1** : dictionary
    - **row2** : dictionary
    - **answer** : 2D array
    - **difficulty** : string
    - **questionID** : int
    - **subject** : string

    - **Questions** (Static, global variable): a global variable in the class that stores all questions in an array

    ### Functions
    - **initializer**: this functions is the initialize method for the class. 

    - **parseJsonFile()** : This function opens the json file and converts all json objects to a python class

    - **getQuestionByID(id, type)** : returns the question with the specified ID and type

    - **getRandomQuestionBySubject(subject)** : returns a random question based on the specified subject and type


    - **getRandomQuestionByDifficulty(subject, type)** : returns a random question based on 




- # MultipleChoice.py

    ### Properties
    - **Question** : string
    - **answer** : string
    - **difficulty** : string
    - **question_id** : int
    - **subject** : string
    - **options** : array of strings
    - **Questions** (Static, global variable): a global variable in the class that stores all questions in an array

    - **Questions** (Static, global variable): a global variable in the class that stores all questions in an array

    ### Functions

    - **initializer**: this functions is the initialize method for the class. 

    - **parseJsonFile()** : This function opens the json file and converts all json objects to a python class

    - **getQuestionByID(id, type)** : returns the question with the specified ID and type

    - **getRandomQuestionBySubject(subject)** : returns a random question based on the specified subject and type


    - **getRandomQuestionByDifficulty(subject, type)** : returns a random question based on 





# Functions for Questions

For each qyestion type there are 3 functions(per json file)


- getQuestionByID(id, type) : returns the question with the specified ID and type

- getRandomQuestionBySubject(subject) : returns a random question based on the specified subject and type


- getRandomQuestionByDifficulty(subject, type) : returns a random question based on 



# Example of an object: 

### Fill in the blank (FillInTheBlank.py)

```python

class FillInTheBlank: 

    questions = []

    def __init__(self, question, answer, question_id, difficulty, subject):
        self.question = question
        self.answer = answer
        self.question_id = question_id
        self.difficulty = difficulty
        self.subject = subject

        questions.append(self)

    def parseJsonFile() :
        ## Parse the json file and convert each json object into a python class of type FillInTheBlanks. (The initializer will automatically appends the new object to the statis variable 'questions')

```