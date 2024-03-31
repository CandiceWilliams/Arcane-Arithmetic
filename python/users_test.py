import users 



u = users.User("j", "password123", "aaaaa", "admin")

if u.insertIntoDB() == False:
    print("Already exist")



print(users.User.getUserByUsername("abcd").password)