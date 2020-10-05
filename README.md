## Number Guesser
This app is the backend of a number guesser, think of a number between 1 and 1000 and see how many attempts and how long the program guesses the number thought. Press "less" if the computer's attempt is bigger than its intended number, press "bigger" if it is less and "Same" if the number is correct.

### To start:

run as Spring Boot App the class com.gabrielcoutinho.numberguesser.NumberguesserApplication

Start this app before your [frontend](https://github.com/gabriel-coutinho/NumberGuesserFrontend)

```shell
$ Runing on http://localhost:8080
```

### To acess the database:

Only when app is running
URL http://localhost:8080/h2-console:
Fields on console:
-Driver Class: org.h2.Driver
-JDBC URL:	jdbc:h2:file:~/test
-User Name: sa
-Password:


