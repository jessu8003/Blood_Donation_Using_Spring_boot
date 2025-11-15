Blood Donation Management System – Spring Boot Project

A web-based Spring Boot application designed to connect blood donors with patients in need.
The system allows users to register, donate blood, request blood, and automatically notifies matching donors via email.

🌟 Features
👤 User Module

User Registration

User Login (Session-based)

View all registered users

Update/Delete user information

🩸 Donor Module

Donor registration based on logged-in user details

View all donor details

Filter donors by:

Name

Gender

Email

Address

Blood Group

📧 Email Notification System

Send request email to a single donor

Send bulk email to all donors matching a required blood group

Detailed professional email format including:

Patient Name

Patient Age

Required Blood Group

Hospital Name

Hospital Address

Contact Number

🔐 Security & Validation

Custom exception handling

Duplicate email, mobile, password validation

Session-based authentication

Unique constraints at database level

🏗 Tech Stack
Layer	Technology
Frontend	HTML, CSS, Bootstrap, Thymeleaf
Backend	Java, Spring Boot, Spring MVC, Spring Data JPA
Database	MySQL
Mailing Service	Spring Email (JavaMailSender)
Build Tool	Maven
IDE	STS / Eclipse / IntelliJ
📁 Project Structure
src/main/java/com/demo
│
├── controller       → Handles all HTTP requests
├── service          → Business logic layer
│   ├── UserService
│   ├── DonorService
│   └── EmailService
│
├── DAO              → Data access helper layer
├── repo             → Spring Data JPA Repositories
├── entity           → JPA Entities (UserInformation, DonorDetails)
└── exception        → Custom exceptions + Global Handler

🗄 Database Tables
UserInformation
Field	Type
username	VARCHAR
useremailid (PK)	VARCHAR
userpassword	VARCHAR
usermobilenumber	BIGINT
useraddress	VARCHAR
usergender	VARCHAR
DonorDetails
Field	Type
donorid (PK)	INT AUTO
donorname	VARCHAR
donormobilenumber	BIGINT
donoremailid	VARCHAR
donoraddress	VARCHAR
donorgender	VARCHAR
donorage	INT
bonorbloodgroup	VARCHAR
⚙️ How to Run the Project
1. Clone Repository
git clone <your-github-repo-url>

2. Configure MySQL

Create a database:

CREATE DATABASE teca66Springboot;

3. Update application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/teca66Springboot
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Configure Email

Use your Gmail App Password:

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=yourgmail@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

5. Run Application

Using IDE:

✔ Right-click → Run as → Spring Boot App

