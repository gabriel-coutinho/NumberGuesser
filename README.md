## Number Guesser
This app is the backend of a number guesser, think of a number between 1 and 1000 and see how many attempts and how long the program guesses the number thought. Press "less" if the computer's attempt is bigger than its intended number, press "bigger" if it is less and "Same" if the number is correct.

### To start:

run as Spring Boot App the class com.gabrielcoutinho.numberguesser.NumberguesserApplication

Start this app before your [frontend](https://github.com/gabriel-coutinho/NumberGuesserFrontend)

```shell
$ Runing on http://localhost:8080
```

## Technologies

```shell
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.4.0-SNAPSHOT</version>
```
```shell
<java.version>11</java.version>
```
```shell
<groupId>org.hibernate</groupId>
<artifactId>hibernate-validator</artifactId>
<version>6.0.13.Final</version>
```
```shell
<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<scope>runtime</scope>
```

### To acess the database:

Only when app is running <br />
URL http://localhost:8080/h2-console <br /> <br />
Fields on console: <br />
-Driver Class: org.h2.Driver <br />
-JDBC URL:	jdbc:h2:file:~/test <br />
-User Name: sa <br />
-Password:


