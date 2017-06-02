## Synopsis

If the purpose of this test was to get a full understanding of the facebook API then I have failed, however if it 
wasn't then lets hope you enjoy the combination of technologies
The implementation includes but is not limited to spring boot, RESTfulwebservices, JDBCODBC bridge connection to postgres and a Scheduler


##Motivation
Spring boot
- Self Contained Stand alone application without the need for a container

RESTfulwebservices 
- as I could not get the Facebook Api to connect 
   (see line 123 on hire.morgan.controllers.FBFeedController.java for the Commented out code that would create a header with the paramaters and send to the url  )
   I decided to create my own RESTful client to show knowledge
   
JDBC/ODBC bridge
- It is lighter than the JPA/Hibernate/Auto generated code it also requires SQL Queries for functionality

Scheduler
 - Just seemed to be the easiest way to have the process have run constantly
  

## Installation

The project runs a standalone service using Spring boot, the project is mavenised so one would just need to import,update the DB constants then  clean build to their IDE and run it
I have built the project to connect to a Postgres DB, please change the relevant details (path, User, Password etc) onto hire.morgan.constants.Constants.java,
to get the sql statements just run {yourURL}:8080/sqlStatements
 

## JSON Data call

To get all the Data in the post_details table in JSON fromat just run {yourURL}:8080/data

