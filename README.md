<img align="right" src="https://github.com/ada-school/module-template/blob/main/ada.png">


## Spring Boot Data with MongoDB

**Learning Objectives**

- Explain what MongoDB is.
- Explain the difference between SQL and NoSQL.
- Create a MongoDB Cluster on Atlas.
- Connect your Spring Boot project with a MongoDB Cluster.


## Detail Orientation 🤹🏽

Read the following document [Attention to details](https://www.csu.edu/humanresources/empdev/documents/AttentiontoDetail.pdf) 

**Main Topics**

* NoSQL.
* MongoDB.
* Cluster.



## Codelab 🧪

🗣️ "I hear and I forget I see and I remember I do and I understand." Confucius




### Part 1: Creating your Atlas account and first cluster:

If you haven't created your MongoDB Cluster follow part 1 - 4:

* [Get Started with Atlas](https://docs.atlas.mongodb.com/getting-started/)

### Part 2: Connecting my MongoDB Cluster with Spring Boot

1. Login into your [MongoDB Atlas account](https://account.mongodb.com/account/login)
2. Click *connect* on the cluster you created on Part 1:
   <img align="center" src="img/mongo-db-connect.png">
3. Select *Connect your application*:
   <img align="center" src="img/connect-your-application.png">
4. Choose the *Java* driver, select the latest version and copy the *connection string*:
   <img align="center" src="img/java-driver.png">
5. Replace the *password* on the *connection string* with the password used when creating your database user.
6. Add an *Environment Variable* to the *application.properties* file to store the MongoDB URI:
    ````properties
    spring.data.mongodb.uri=${MONGODB_URI}
    ````
7. Add the environment variable to IntelliJ Idea by editing the Run/Debug Configurations:
   <img align="center" src="img/p9.JPG">
   
8. Add the Spring Boot starter data MongoDB dependency to your *build.gradle*:
    ```groovy
       dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-web'
            implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
            testImplementation 'org.springframework.boot:spring-boot-starter-test'
        }
    ```
9. Run your project and verify that the connection is successful.

   <img align="center" src="img/p8.JPG">

### Part 3: Implementing the MongoDB Service

1. Create a new package called *repository*.
2. Create a new class called *UserDocument*:

   <img align="center" src="img/p12.JPG">
   
3. Create a new interface called *UserRepository* inside the repository package:

  <img align="center" src="img/p10.JPG">

4. Create a new *UserService* implementation called *UserServiceMongoDB* and inject inside the *UserRepository*:
5. Implement the methods of the *UserServiceMongoDB* using the *UserRepository*.
6. Remove the *@Service* annotation from the *UserServiceHashMap* and add it to the *UserServiceMongoDB*.

<img align="center" src="img/p11.JPG">

7. Test your API and verify that your data is stored in your cluster.
**create**

<img align="center" src="img/p1.JPG">

**all**

<img align="center" src="img/p2.JPG">

**findById**

<img align="center" src="img/p3.JPG">

**update**

<img align="center" src="img/p4.JPG">

**delete**

<img align="center" src="img/p5.JPG">

### Challenge Yourself: Implement complex queries using the Spring Data Query Methods
1. Modify the *UserService* interface adding the following methods:

   
**findUsersWithNameOrLastNameLike**

<img align="center" src="img/p6.JPG">
<img align="center" src="img/p13.JPG">

**findUserCreatedAfter**

<img align="center" src="img/p7.JPG">
<img align="center" src="img/p14.JPG">


***Tip***: take a look at the official documenation and learn how to create custom queries with [Spring Data](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)

    

