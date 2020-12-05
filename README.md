# Online House Renting System (Under Development)
## Project Description

Deployed to Heroku: https://houserentingsystem.herokuapp.com/HouseRentingSystem/login
(Heroku leaves the application inactive when there is no activity. You may get
404 - Not Found message until the application fully starts up)

Test Logon
Username: root
Password: password

This project idea is from
https://data-flair.training/blogs/java-project-ideas/.
House rental portal is a web-based java project
where house owners, clients, customers can exchange
information effectively and inexpensively.
This system provides a user-friendly interface,
satisfying the needs of the consumers. It also employs a
new strategy that facilitates easy management of rental houses.

There are three users in this system- Owner, Admin, and Customer.
The owner is the user who owns the house and wants it to give it
for rent. The owner will upload all the details of the house,
including the number of rooms, locality, rent. Admin manages all
the users of the system. Customer is the one who is looking for
a rental house. He can search the house according to the
requirements and get the results accordingly.

The application provides RESTful API endpoints for integration.

## Built With
* Maven: Build Tool
* Intellij NetBrain Community Edition: IDE
* MySQL v8.0: Database
* Payara Micro: Application Server
* Insomnia Core: Testing REST Web Service

## Libraries, Frameworks, and Languages
* Java Persistence API
* Java Context and Dependency Injection
* JAX-RS
* JSP
* Servlets
* HTML
* CSS
* Javascript
* Bootstrap

## Usage
Replace values inside square brackets([ ]) with actual values. Don't include square brackets.

java -jar [payara-micro-5.2020.5.jar] --deploy [HouseRentingSystem.war] --port [8080]

To create an uber jar, execute the command below.

java -jar [payara-micro-5.2020.5.jar] --deploy [HouseRentingSystem.war] --port [8080]
-- outputUberJar [HouseRentingSystemUber.jar]

## REST Endpoints

### User Accounts
* POST    /HouseRentingSystem/api/v1/user/create
* DELETE  /HouseRentingSystem/api/v1/user/delete
* DELETE  /HouseRentingSystem/api/v1/user/delete/{id}
* GET     /HouseRentingSystem/api/v1/user/get/{id}
* GET     /HouseRentingSystem/api/v1/user/list
* PUT     /HouseRentingSystem/api/v1/user/update
* GET     /HouseRentingSystem/api/v1/user/email-exists/{email}
* GET     /HouseRentingSystem/api/v1/user/find-username/{username}
* GET     /HouseRentingSystem/api/v1/user/username-exists/{username}

### Houses
* POST    /HouseRentingSystem/api/v1/house/create
* DELETE  /HouseRentingSystem/api/v1/house/delete
* DELETE  /HouseRentingSystem/api/v1/house/delete/{id}
* GET     /HouseRentingSystem/api/v1/house/get/{id}
* GET     /HouseRentingSystem/api/v1/house/list
* PUT     /HouseRentingSystem/api/v1/house/update

### Rentals
* POST    /HouseRentingSystem/api/v1/rental/create
* DELETE  /HouseRentingSystem/api/v1/rental/delete
* DELETE  /HouseRentingSystem/api/v1/rental/delete/{id}
* GET     /HouseRentingSystem/api/v1/rental/get/{id}
* GET     /HouseRentingSystem/api/v1/rental/list
* PUT     /HouseRentingSystem/api/v1/rental/update