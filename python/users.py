import random
import string
import json
import platform

system = platform.system()


class User: 
     
        def __init__(self, username, password, name, privilege, id=""): 
                """
                    Initialize method
                    
                    :param username: user's username
                    :type username: string
                    
                    :param password: user's password
                    :type password: string
                    
                    :param name: user's name
                    :type name: string
                    
                    :param privilege: user's privilege
                    :type privilege: string
                    
                    :param id: user's unique ID
                    :type id: string
                    
                    :return: a new user
                    :rtype: User
                """            
                self.username = username
                self.password = password
                self.name = name
                self.privilege = privilege
                if id == "":
                    characters = string.ascii_letters + string.digits
                    self.id = str(''.join(random.choices(characters, k=10)))
                else:
                    self.id = id


        def insertIntoDB(self):
            """
                This function inserts a new user into the database

                :return: True if it is successful and False if user already exists 
                :rtype: Boolean
            """
            
            if system == "Windows":
                filedir = "DatabaseFiles\\users.json"
            else:
                filedir = "DatabaseFiles/users.json"

            if User.getUserByUsername(self.username) != None : 
                return False
            
            json_struct = '''{{"username": "{}","password": "{}","id": "{}","name": "{}","privilege": "{}"}}'''.format(self.username, self.password, self.id, self.name, self.privilege)
            new_user = json.loads(json_struct)
            try:
                # Read the existing data
                with open(filedir, 'r') as file:
                    data = json.load(file)

                # Append the new user
                data.append(new_user)

                # Write the updated data back to the file
                with open(filedir, 'w') as file:
                    json.dump(data, file, indent=4)
                    
                return True
            except Exception as e:
                print(f"An error occurred: {e}")
            
            
            
        def getUserByID(id):
            """
                Returns the user with the given ID

                :param id: User's unique ID
                :type id: string
                :return: The user with the given ID
                :rtype: User
            """
            if system == "Windows":
                filedir = "DatabaseFiles\\users.json"
            else:
                filedir = "DatabaseFiles/users.json"
                
                
            with open(filedir, 'r') as file:
                data = json.load(file)
                
                for i in data:
                    if i["id"] == id :
                        u = User(i["username"], i["password"], i["name"], i["privilege"], id)
                        return u
                    
                return None
        
        
    
        def getUserByUsername(username):
            """
                Returns the user with the give username

                :param username: user's username
                :type username: string
                :return: The user with the given username
                :rtype: User
            """
            
            if system == "Windows":
                filedir = "DatabaseFiles\\users.json"
            else:
                filedir = "DatabaseFiles/users.json"
                
                
            with open(filedir, 'r') as file:
                data = json.load(file)
                
                for i in data:
                    if i["username"] == username :
                        u = User(i["username"], i["password"], i["name"], i["privilege"], i["id"])
                        return u
                return None
                    
        
        
        