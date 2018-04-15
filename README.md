# bv-technical-test

This application can monitor the insertions into the database.

### Build

1. Clone or download the project
1. Open a terminal in the project folder
1. Run the following maven command to build the project (Download and install maven if needed)

    `mvn clean package`


### Run

1. Go to the created target folder
1. Run the following command (Download and install Java Runtime Environment if needed)

    `java -jar demo-0.0.1-SNAPSHOT.jar`


3. To run the application on a specific port (eg: 9000) use the following command

    `java -Dserver.port=9000 -jar demo-0.0.1-SNAPSHOT.jar`


### Use

1. Open in browser: http://localhost:8080

1. Push the 'Connect' button to connect the websocket and subscribe the server messages

1. Fill the FirstName, LastName, Age fields and push the 'Send' button to insert a new person in the database

1. After the successful insertion a new message appears on the page from the server with the details

1. You can connect with multiple browsers/tabs in the same time

1. Check the status of the application: http://localhost:8080/status

1. Check the version of the application: http://localhost:8080/version


### Test

1. Run the following command in the project folder

    `mvn test`


### Database

Go to the http://localhost:8080/db to connect the database. 

* Driver class: org.h2.Driver
* JDBC URL: jdbc:h2:mem:testdb
* User Name: sa
* Password: ""
