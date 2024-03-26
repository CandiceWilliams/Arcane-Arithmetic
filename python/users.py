import random
import string
import json


class User: 
     
        def __init__(self, username, password, name, privilege, id=""): 
                self.username = username
                self.password = password
                self.name = name
                self.privilege = privilege
                if id == "":
                    characters = string.ascii_letters + string.digits
                    self.id = ''.join(random.choice(characters) for _ in range(10))
                else:
                    self.id = id


        def insertIntoDB(self):
            if User.getUserByUsername(self.username) != None : 
                return False
            
            json_struct = '''{{"username": "{}","password": "{}","id": "{}","name": "{}","privilege": "{}"}}'''.format(self.username, self.password, self.id, self.name, self.privilege)
            new_user = json.loads(json_struct)
            try:
                # Read the existing data
                with open("DatabaseFiles/users.json", 'r') as file:
                    data = json.load(file)

                # Append the new user
                data.append(new_user)

                # Write the updated data back to the file
                with open("DatabaseFiles/users.json", 'w') as file:
                    json.dump(data, file, indent=4)
                    
                return True
            except Exception as e:
                print(f"An error occurred: {e}")
            
            
            
        def getUserByID(id):
            with open("DatabaseFiles/users.json", 'r') as file:
                data = json.load(file)
                
                for i in data:
                    if i["id"] == id :
                        u = User(i["username"], i["password"], i["name"], i["privilege"], id)
                        return u
                    
                return None
        
        
    
        def getUserByUsername(username):
            with open("DatabaseFiles/users.json", 'r') as file:
                data = json.load(file)
                
                for i in data:
                    if i["username"] == username :
                        u = User(i["username"], i["password"], i["name"], i["privilege"], id)
                        return u
                return None
                    
        
        
        def Authenticate(username, password) :
            with open("DatabaseFiles/users.json", 'r') as file:
                data = json.load(file)
            
            for i in data:
                    if i["username"] == username :
                        if i["password"] == password :
                            return True
                        else:
                            return False
            
            return False