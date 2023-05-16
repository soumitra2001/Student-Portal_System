
<h1 align="center">🧑‍🎓📚 Student Portal Application💻 </h1>

The main purpose of this application is to provide courses for `Students` and also sell some `Course`,`Books` as well as `Laptops` also.

Students can search for the available courses, Book and Laptop which they can buy also.



## Frameworks and Language used

[![JAVA Docs](https://img.shields.io/badge/JAVA-v20.0.1-blue.svg)](https://docs.oracle.com/en/java/)
[![GPLv3 License](https://img.shields.io/badge/Spring_Boot-v3.0.6-yellow.svg)](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)


## Required Dependencies

To run this project, you will need to add the following dependencies to your pom.xml file

`Spring Web`,`Spring Boot Dev Tool`,`Lombok`,`Spring Data JPA`,`Validation`,`MySQL Driver`



## API Reference

### `Student`

#### Get all student

```http
  GET /student/all
```

#### Student SignUp

```http
  POST /student/signup
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `SignUpInput`      | `SignUpInput` | **Required**. SignUpInput type of `Object` to pass through the requestbody|


#### Student SignIn

```http
  POST /student/signin
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `SignInInput`      | `SignInInput` | **Required**. SignInInput type of `Object` to pass through the requestbody|

#### Student LogOut

```http
  POST /student/logout
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Email`      | `String` | **Required**. student email-Id|

#### Student Buy_Course

```http
  POST /student/course
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Token`      | `String` | **Required**.Authentication token for authenticate the student|
| `CourseName`      | `String` | **Required**.for allocate this course for given student|

### `Course`

#### Get all Course

```http
  GET /course/all
```
#### Add Course

```http
  POST /course
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `course`      | `Course` | **Required**. Course type of `Object` to pass through the requestbody|

#### Delete Course

```http
  Delete /course
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. course id for delete the particular course|

### `Book`

#### Get all Book

```http
  GET /book/all
```
#### Add Book

```http
  POST /book
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `book`      | `Book` | **Required**. Book type of `Object` to pass through the requestbody|

#### Delete Book

```http
  Delete /course
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Long` | **Required**. book id for delete the particular book|



## DataBase Design
#### Used MySQL DataBase

```
    create table address (
       address_id bigint not null auto_increment,
        country varchar(255),
        district varchar(255),
        landmark varchar(255),
        state varchar(255),
        zipcode varchar(255),
        primary key (address_id)
    ) 
    create table authentication_token (
       token_id bigint not null auto_increment,
        token varchar(255),
        token_creation_date date,
        fk_student_id bigint,
        primary key (token_id)
    ) 
    create table book (
       book_id bigint not null auto_increment,
        book_author varchar(255),
        book_description varchar(255),
        book_price float(53),
        book_title varchar(255),
        fk_student_id bigint,
        primary key (book_id)
    ) 
    create table course (
       course_id bigint not null auto_increment,
        course_description varchar(255),
        course_duration varchar(255),
        course_title varchar(255),
        primary key (course_id)
    )
    create table course_students (
       course_course_id bigint not null,
        students_student_id bigint not null
    )
    create table laptop (
       laptop_id bigint not null auto_increment,
        laptop_brand varchar(255),
        laptop_name varchar(255),
        laptop_price integer,
        fk_student_id bigint,
        primary key (laptop_id)
    )
    create table student (
       student_id bigint not null auto_increment,
        batch_name varchar(255),
        student_age integer,
        student_department varchar(255),
        student_email varchar(255),
        student_name varchar(255),
        student_password varchar(255),
        student_ph_no varchar(255),
        fk_address_id bigint,
        primary key (student_id)
    ) 
    alter table book 
       drop index UK_1197qonasf2lusmijxr662hc0

    alter table book 
       add constraint UK_1197qonasf2lusmijxr662hc0 unique (book_title)
    
    alter table course 
       drop index UK_iooeennn0x5ypsevqs54an4bc
    
    alter table course 
       add constraint UK_iooeennn0x5ypsevqs54an4bc unique (course_title)

    alter table laptop 
       drop index UK_73kv3euhwovl14thrqxg9s706
    
    alter table laptop 
       add constraint UK_73kv3euhwovl14thrqxg9s706 unique (laptop_name)
    
    alter table student 
       drop index UK_qm8ww2m2nj6rqaroqqelj9vl5
    
    alter table student 
       add constraint UK_qm8ww2m2nj6rqaroqqelj9vl5 unique (student_email)
    
    alter table authentication_token 
       add constraint FK25eafdhqc00uuwwp1in5lclxo 
       foreign key (fk_student_id) 
       references student (student_id)
    
    alter table book 
       add constraint FK8bwyb0awpocxk4043dps3dgb7 
       foreign key (fk_student_id) 
       references student (student_id)
    
    alter table course_students 
       add constraint FKq13i3igkhjdm4cikr2f37674r 
       foreign key (students_student_id) 
       references student (student_id) 
    
    alter table course_students 
       add constraint FKg4o63m74ojtok51gh54r4o7pg 
       foreign key (course_course_id) 
       references course (course_id)
    
    alter table laptop 
       add constraint FK1fve7gjcqmxqucqqskv0127j3 
       foreign key (fk_student_id) 
       references student (student_id)
    
    alter table student 
       add constraint FKqpcdip0y64uei9q2ddcodk4qa 
       foreign key (fk_address_id) 
       references address (address_id)
```


### Data Structure used in project :
- List

## Project Summary :

````
  This is a Spring Boot project of basic Student portal system. Student can register themselves by filling the required information.
  Upon registration basic validation applied to the filled data if all the validation passes then and only then a data is registered into the system.
  Student can able to study by get some Course, Book etc, can look into all the courses, books. Whereas,
  Student can able to update their required information from the registered data using the Basic Student API.
  AtLast Student also can delete their account forever.

