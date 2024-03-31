import users 



u = users.User("abcd", "password123", "aaaaa", "admin")

if u.insertIntoDB() == False:
    print("Already exist")



print(users.User.getUserByUsername("abcd").password)