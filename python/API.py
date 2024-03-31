from flask import Flask, request, Response
import json
import users
from MatchingQuestions import MatchingQuestions 
from FillInTheBlank import FillInTheBlank
from MCQuestions import MCQuestions



def convertToJsonString(username, password, id, name, privilege):
    return '''{{"username": "{}","password": "{}","id": "{}","name": "{}","privilege": "{}"}}'''.format(username, password, id, name, privilege)



app = Flask(__name__)

'''
Request Parameter Structure
{
    "username": string,
    "password": string, 
    "name": string, 
    "privilege": string
}
'''

@app.route("/database/users/insert")
def insertUser():
    data = request.args.get("data")
    data = json.loads(data)
    
    if data == "":
        response = Response('''{"Error": "No field specified"}''')
        response.headers['Content-Type'] = 'application/json'
        
        return response
    
    if users.User.getUserByUsername(data["username"]) != None:
        response = Response('''{"Error": "User already exists"}''')
        response.headers['Content-Type'] = 'application/json'
        return response
        
        
    u = users.User(data["username"], data["password"], data["name"], data["privilege"])
    u.insertIntoDB()
    
    response = Response(convertToJsonString(u.username, u.password, u.id, u.name, u.privilege))
    response.headers['Content-Type'] = 'application/json'
    
    return response

    


@app.route("/database/users/get")
def getUser():
    data = request.args.get("username")
    field = "ByUsername"
    
    
    if data == None :
        field = "ByID"
        data = request.args.get("id")
        if data == None :
            response = Response('''{"Error": "No field specified"}''')
            response.headers['Content-Type'] = 'application/json'
            return response
    
    
    
    if field == "ByUsername":
        u = users.User.getUserByUsername(data)
        if u == None:
            response = Response('''{"Error": "User Not Found"}''')
            response.headers['Content-Type'] = 'application/json'
            return response
        response = Response(convertToJsonString(u.username, u.password, u.id, u.name, u.privilege))
        response.headers['Content-Type'] = 'application/json'
        return response
    else:
        u = users.User.getUserByID(data)
        if u == None:
            response = Response('''{"Error": "User Not Found"}''')
            response.headers['Content-Type'] = 'application/json'
            return response
        
        
        response = Response(convertToJsonString(u.username, u.password, u.id, u.name, u.privilege))
        response.headers['Content-Type'] = 'application/json'
        return response
    
######################################################################################################################################################
##################################################Questions###########################################################################################
######################################################################################################################################################
@app.route("/database/questions/get")
def questionsHandler():
    subject = request.args.get("subject")
    difficulty = request.args.get("difficulty")
    type = request.args.get("type")
    id = request.args.get("id")
    
    valid_subjects = ["calculus", "statistics", "algebra"]
    valid_difficulties = ["easy", "medium", "difficult"]
    valid_types = ["mc", "matching", "fb"]
    
    
    if type not in valid_types:
        response = Response('''{"Error": "Invalid Argument 'type'"}''')
        response.headers['Content-Type'] = 'application/json'
        return response
    
    if type == None:
        response = Response('''{"Error": "Missing Argument 'type'"}''')
        response.headers['Content-Type'] = 'application/json'
        return response
        
    
    if id != None:
        id = int(id)
        if type == "matching":
            MatchingQuestions.parseJsonFile()
            q = MatchingQuestions.getQuestionByID(id)
        elif type == "mc":
            MCQuestions.parseJsonFile()
            q = MCQuestions.getQuestionByID(id)
        else:
            FillInTheBlank.parseJsonFile()
            q = FillInTheBlank.getQuestionByID(id)
        
        if q == None:
            response = Response('''{"Error": "Question Not Found"}''')
            response.headers['Content-Type'] = 'application/json'
            return response
        
        
        json_string = json.dumps(q, default=lambda o: o.to_serializable(), indent=4)
        response = Response(json_string)
        response.headers['Content-Type'] = 'application/json'
        return response
    
    
    
    
    elif difficulty != None:
        if difficulty not in valid_difficulties:
            response = Response('''{"Error": "Invalid Argument 'difficulty'"}''')
            response.headers['Content-Type'] = 'application/json'
            return response
        if type == "matching":
            MatchingQuestions.parseJsonFile()
            q = MatchingQuestions.getRandomQuestionByDifficulty(difficulty)
        elif type == "mc":
            MCQuestions.parseJsonFile()
            q = MCQuestions.getRandomQuestionByDifficulty(difficulty)
        else:
            FillInTheBlank.parseJsonFile()
            q = FillInTheBlank.getRandomQuestionByDifficulty(difficulty)
        
        json_string = json.dumps(q, default=lambda o: o.to_serializable(), indent=4)
        response = Response(json_string)
        response.headers['Content-Type'] = 'application/json'
        return response
    elif subject != None:
        if subject not in valid_subjects:
            response = Response('''{"Error": "Invalid Argument 'subject'"}''')
            response.headers['Content-Type'] = 'application/json'
            return response
        
        if type == "matching":
            MatchingQuestions.parseJsonFile()
            q = MatchingQuestions.getRandomQuestionBySubject(subject)
        elif type == "mc":
            MCQuestions.parseJsonFile()
            q = MCQuestions.getRandomQuestionBySubject(subject)
        else:
            FillInTheBlank.parseJsonFile()
            q = FillInTheBlank.getRandomQuestionBySubject(subject)
        
        json_string = json.dumps(q, default=lambda o: o.to_serializable(), indent=4)
        response = Response(json_string)
        response.headers['Content-Type'] = 'application/json'
        return response
    else:
        response = Response('''{"Error": "Missing Arguments"}''')
        response.headers['Content-Type'] = 'application/json'
        return response
        
        
        
           
            
        






if __name__ == '__main__':
    app.run(debug=False)