import json
import platform

system = platform.system()


class Record:
    
    """
    This class represents a a record for rankings and it includes all essential functions for ranking table
    """
    
    def __init__(self, totalPoints, totalWon, totalPlayed, totalCorrect, totalIncorrect, ownerID):
        self.totalPoints = int(totalPoints)
        self.totalWon = int(totalWon)
        self.totalPlayed = int(totalPlayed)
        self.totalCorrect = int(totalCorrect)
        self.totalIncorrect = int(totalIncorrect)
        self.ownerID = ownerID
        
        
        
    
    def insertIntoDB(self):
            """
            Inserts a new record into the database file. If a record with the same ownerID already exists, it is replaced.
            Returns:
                str: JSON structure of the inserted record.
            Raises:
                Exception: If an error occurs during file operations or JSON serialization.
            """
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
            """
            Retrieves all records from the database file.
            Returns:
                str: Contents of the database file.
            Raises:
                FileNotFoundError: If the database file is not found.
            """
            if system == "Windows":
                filedir = "DatabaseFiles\\ranks.json"
            else:
                filedir = "DatabaseFiles/ranks.json"
                
            with open(filedir, "r") as file:
                file_contents = file.read()
            
            return file_contents
            
        
    def getByID(id):
        """
        Retrieves a record from the database file based on the provided ID.
        Args:
            id (str): The ownerID of the record to retrieve.
        Returns:
            str: JSON structure of the retrieved record, or an empty string if not found.
        """
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
        """
        Deletes a record from the database file based on the provided ID.
        Args:
            id (str): The ownerID of the record to delete.
        Raises:
            ValueError: If the provided ID is not found in the database file.
        """
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
            
    
        