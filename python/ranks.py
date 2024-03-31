import json
import platform

system = platform.system()


class Record:
    
    
    def __init__(self, totalPoints, totalWon, totalPlayed, totalCorrect, totalIncorrect, ownerID):
        self.totalPoints = int(totalPoints)
        self.totalWon = int(totalWon)
        self.totalPlayed = int(totalPlayed)
        self.totalCorrect = int(totalCorrect)
        self.totalIncorrect = int(totalIncorrect)
        self.ownerID = ownerID
        
        
        
    
    def insertIntoDB(self):
            if system == "Windows":
                filedir = "DatabaseFiles\\ranks.json"
            else:
                filedir = "DatabaseFiles/ranks.json"
            
            json_struct = '''{{"totalPoints" : {}, "totalWon" : {}, "totalPlayed" : {}, "totalCorrect" : {}, "totalIncorrect" : {}, "ownerID" : "{}"}}'''.format(self.totalPoints, self.totalWon, self.totalPlayed, self.totalCorrect, self.totalIncorrect, self.ownerID)
            new_user = json.loads(json_struct)
            
            
            r = Record.getByID(self.ownerID)
            if r != None:
                Record.deleteByID(self.ownerID)
                
            
            try:
                with open(filedir, 'r') as file:
                    data = json.load(file)
                data.append(new_user)

                with open(filedir, 'w') as file:
                    json.dump(data, file, indent=4)
                    
                return json_struct
            except Exception as e:
                print(f"An error occurred: {e}")
            
            
            return json_struct
                
                
        
        
    def getAll():
            if system == "Windows":
                filedir = "DatabaseFiles\\ranks.json"
            else:
                filedir = "DatabaseFiles/ranks.json"
                
            with open(filedir, "r") as file:
                file_contents = file.read()
            
            return file_contents
            
        
    def getByID(id):
        if system == "Windows":
            filedir = "DatabaseFiles\\ranks.json"
        else:
            filedir = "DatabaseFiles/ranks.json"
                
        with open(filedir, "r") as file:
            data = json.load(file)
        
        for obj in data: 
            if obj["ownerID"] == id:
                return '''{{"totalPoints" : {}, "totalWon" : {}, "totalPlayed" : {}, "totalCorrect" : {}, "totalIncorrect" : {}, "ownerID" : "{}"}}'''.format(obj["totalPoints"],obj["totalWon"],obj["totalPlayed"],obj["totalCorrect"],obj["totalIncorrect"],obj["ownerID"])
        
        return ""
    
        
        
    def deleteByID(id):
        if system == "Windows":
            filedir = "DatabaseFiles\\ranks.json"
        else:
            filedir = "DatabaseFiles/ranks.json"
                
        with open(filedir, "r") as file:
            data = json.load(file)
        
        for obj in data: 
            if obj["ownerID"] == id:
                data.remove(obj)
                break
        
        with open(filedir, 'w') as file:
            json.dump(data, file, indent=4)
            
    
        