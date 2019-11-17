#### Spring boot Application Description.
Following operations are performed.

1. ***Create user***
2. ***Delete user***
3. ***Find user based on some criteria***
4. ***Use Spring events to publish some events***
 
 
 ####Technologies used
 1. In Memory database (H2)
 2. Spring JPA Data
 3. Spring Boot
 4. Tomcat Server

This project contains two application.properties file which is prod and test which is loaded on
basis of Spring profile selected either passed through maven arugment or placed in application.properties.

***Base_URL = http://shamsher.southindia.cloudapp.azure.com:8080/***
#### Api End points Details 
* #### Create User


END_POINT = /createUser

Complete Url : http://shamsher.southindia.cloudapp.azure.com:8080/createUser

Payload : 
{
    "firstName":"David",
    "lastName":"Thorn",
    "emailId":"davi@demo.com"
}

* #### Delete user 

END_POINT = /deleteUser

Request Type = DELETE

Compelete Url :http://shamsher.southindia.cloudapp.azure.com:8080/deleteUser?email_id=david@demo.com

* #### Get User From Last Name
END_POINT = /getUsersFromLastName

Request Type = POST

Complete Url : http://shamsher.southindia.cloudapp.azure.com:8080/getUsersFromLastName?last_name=thorn

* #### Get user from first Name

END_POINT = /getUsersFromFirstName

Request Type = POST

Complete Url : http://shamsher.southindia.cloudapp.azure.com:8080/getUsersFromFirstName?first_name=thorn


* #### Get user from first Name

END_POINT = /getUserFormEmail

Request Type = POST

Complete Url : http://shamsher.southindia.cloudapp.azure.com:8080/getUsersFromFirstName?email_id=shamsher@demo.com

