# chat_room_final
Chat Room Project 
# Backend Java Chat Server Take-Home coding assessment
# Step 1
*) Make sure you have MySql on your system, Use existing schema on your system.
*) Run entire queries.sql
*) We have created 2 tables users and message. 
*) Insert atlease 2 records in users to demonstrate the chat ( insert queries are provided in queries.sql)
# Step 2 (Chatroomapp Project)
*) Import chatroomapp springboot project into eclipse as a maven project.
*) Right click pom.xml and run for Chatroomapp project. Set goal : clean install
*) This application is running on port 8080 
*) Description Of Project : chatroom app is the project, Which receives request from UI, Intercept it and send message to another service(Project- messageCrud)
*) Right click Demo1Application.java and select Run As 'Springboot Project' option 
# Step 3 (messageCrud Project)
*) Import messageCrud springboot project into eclipse as a maven project.
*) Right click pom.xml and run for messageCrud project. Set goal : clean install
*) This application is running on port 9090 
*) In Application.properties give MySql Database details as per your local database.
*) Right click MessageCrudApplication.java and select Run As 'Springboot Project' option 
*) Error Warning to ignore: You might get below error while running the project. Please ignore the error as project will be up and running successfully.
   Error: Referencing column 'USERID' and referenced column 'USERID' in foreign key constraint 'message_ibfk_1' are incompatible.(ignore this error)

# Step 4
*) Now application is successfully running at localhost:8080 open chrome and paste url (localhost:8080) and login with user and password that you have inserted during queries.sql
*) Once you have entered from one of the browser, Now open another browser pressing CTRL+SHIFT+N ( Chrome in Incognito) enter the details of another user and login.
*) Now two different users can chat with each other and see eachother's messages. User can delete his own messages.
*) More than 2 users can chat with each other and see eachother's messages in real time.
*) Uploading video how to start the project and how the application works in multiuser scenario. (chatroom-tutorial.mp4)


# Other Important Points 
Unit testing classes path inside chatroomapp project is below
*) /chatroomapp/src/main/java/com/chat/app/mockito/api
Unit testing classes path inside messageCrud project is below
*) /chatroomapp/src/main/java/com/chat/app/mockito/api
/messageCrud/src/main/java/com/example/messagecrud/mockito/api

*) Restfull end-points are tested by simply importing ChatRoom Project Testing.postman_collection.json , import this file in Postman 
