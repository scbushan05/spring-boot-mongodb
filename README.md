# Spring boot and MongoDB REST API - CRUD Example

The application demonstrates the REST API using Spring boot and MongoDB. The application demonstrates all the database operations like Create, Read, Update and Delete.

## Tools and Technologies used

* Spring boot 2.1.2
* MongoDB
* Eclipse Oxygen
* Java1.8

> Note: I am using [mLab](https://mlab.com/) for MongoDB database

## Step to install

1. **Clone the application**

```bash
git clone https://github.com/scbushan05/spring-boot-mongodb.git
```

2. **Build and run the backend app using maven**

```bash
cd spring-boot-mongodb-rest-api
mvn package
java -jar target/spring-boot-mongodb-rest-api-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The backend server will start at <http://localhost:8080>.