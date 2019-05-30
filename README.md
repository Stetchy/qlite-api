# QLite API [![Build Status](https://travis-ci.org/Stetchy/qlite-api.svg?branch=master)](https://travis-ci.org/Stetchy/qlite-api)

This is the repository for the backend portion of QLite, my final year project for university.

## Installation

#### Prerequisites
 - Java 8 and its JDK installed
 - Maven

### From source

#### Steps
 - Clone this repo and move into it.
 - Open the `application.properties` file located in `src/main/resources` and input your MongoDB database information.
 - Run `mvn spring-boot:run`, by default the API will run on port 8080 and can be accessed via Swagger too.

### From JAR
 - Download the JAR from the releases tab.
 - Create a file called `application.properties` in the directory where you saved the JAR file and input the following information for your MongoDB database.
    ```
    spring.data.mongodb.host=
    spring.data.mongodb.port=
    spring.data.mongodb.authentication-database=
    spring.data.mongodb.username=
    spring.data.mongodb.password=
    spring.data.mongodb.database=
    ```
 - Open a terminal and run `java -jar QLite-v1.0.0.jar --spring.config.location=./application.properties`, by default the API will run on port 8080 and can be accessed via Swagger too.
