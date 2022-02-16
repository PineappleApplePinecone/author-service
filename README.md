# Author Service
### Getting started
For further reference, please consider the following sections:
* Fork this repository to your IDE
* Configure file -> ```src/main/resources/application.properties```
```
  spring.datasource.url = YOUR_URL
  spring.datasource.username=YOUR_DB_USERNAME
  spring.datasource.password=YOUR_DB_PASSWORD
```
* Connect your DB to application, for MySQL console:
```
  CREATE DATABASE DB_name;
  USE DB_name;
```
* When you run application some information will be added to DB, you can see this data on:
  ```src/main/java/book/injector/DataInjector.class```
### Controllers
GET:
* get all authors -> ```/authors```
* get all books -> ```/books```
* get author by id -> ```/authors/{authorId}```
* get book by id -> ```/books/{bookId}```
* get all author by phrase in the books titles -> ```/books/phrase```

POST:
* add new author to book -> ```/books/{{bookId}}/books/{{authorId}}/add```
* add new author -> ```/authors```
* add new book -> ```/books```

PUT:
* update author by id -> ```/authors/{authorId}```
* update book by id -> ```/book/{bookId}```

DELETE:
* delete author by id -> ```/authors/{authorId}```
* delete book by id -> ```/books/{bookId}```
* remove author from book -> ```/books/{bookId}/authors/{authorId}```
### Technologies used
* Spring Boot
* Java
* Hibernate
* MySQL
* JPQL
* Maven
