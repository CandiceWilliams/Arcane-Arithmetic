import hashlib
import random
import string
import json

DatabaseDir = "DatabaseFiles"

class User: 
        def __sha256_encode__(input_string):
            sha256_hash = hashlib.sha256(input_string.encode())
            return sha256_hash.hexdigest()
        
        def __generate_id__(length):
            characters = string.ascii_letters + string.digits
            random_string = ''.join(random.choice(characters) for _ in range(length))
            return random_string
    
        def __init__(self, username, password, name, privilege): 
                self.username = username
                self.password = __sha256_encode__(input_str)
                self.name = name
                self.privilege = privilege
                self.id = __generate_id__(10)


        def insertIntoDB(self):
            json_struct = '''{"username": "{}","password": "{}","id": "{}","name": "{}","privilege": "{}"}'''.format(self.username, self.password, self.id, self.name, self.privilege)
            new_user = json.loads(json_struct)
            try:
                # Read the existing data
                with open(file_path, 'r') as file:
                    data = json.load(file)

                # Append the new user
                data.append(new_user)

                # Write the updated data back to the file
                with open(file_path, 'w') as file:
                    json.dump(data, file, indent=4)
            except Exception as e:
                print(f"An error occurred: {e}")
                
