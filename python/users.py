import random
import string
import json


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
                    :return: aa new user
                    :rtype: User
                """            
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
            """
                This function inserts a new user into the database

                :return: True if it is successful and False if user already exists 
                :rtype: Boolean
            """

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
            """
                Returns the user with the given ID

                :param id: User's unique ID
                :type id: string
                :return: The user with the given ID
                :rtype: User
            """

            with open("DatabaseFiles/users.json", 'r') as file:
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
            with open("DatabaseFiles/users.json", 'r') as file:
                data = json.load(file)
                
                for i in data:
                    if i["username"] == username :
                        u = User(i["username"], i["password"], i["name"], i["privilege"], id)
                        return u
                return None
                    
        
        
        def Authenticate(username, password) :
            """
                This function is used for log-in window

                :param username: User's username
                :type username: string
                :param password: User's password
                :type password: string
                :return: True if the username and password, False otherwise
                :rtype: Boolean
            """
            with open("DatabaseFiles/users.json", 'r') as file:
                data = json.load(file)
            
            for i in data:
                    if i["username"] == username :
                        if i["password"] == password :
                            return True
                        else:
                            return False
            
            return False
        
        