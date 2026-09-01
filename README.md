# RepMaster – Workout Tracker

RepMaster is a browser-based workout tracking web application developed for the
Java and Web Development project (CSEBCSPJWD01).

The application allows users to create an account, log in, create and manage
workout plans, record completed workouts, and review their workout history.

The project was developed from the Phase 1 concept into a
working Java web application using Spring Boot and MySQL.

---

## Features

### User Accounts
- User registration
- User login
- Personal user data and workout plans

### Workout Management
- Create workout plans
- View saved workouts
- Edit existing workouts
- Delete workouts
- Store workout name, target muscle, exercises, sets and reps

### Workout Logger
- Select a saved workout
- Record the date of the completed workout
- Record workout duration
- Add notes about the workout
- Save completed workout logs

### Workout History
- View previously saved workout logs
- Review the date, duration and notes of completed workouts

### Responsive Design
- Desktop layout
- Mobile layout
- Navigation and content stack vertically on smaller screens
- Forms and workout cards remain usable on phone-sized screens

---

## Technologies Used

### Frontend
- HTML5
- CSS3
- JavaScript
- Fetch API
- Responsive CSS media queries

### Backend
- Java
- Spring Boot
- REST API
- Spring Data JPA

### Database
- MySQL

### Development Tools
- IntelliJ IDEA
- MySQL Workbench
- Git
- GitHub
- Postman

---


## Dynamic Functionality

The main dynamic features are:

### User Registration and Login

Users can create an account and log in to the application. After login, the
dashboard displays the name of the logged-in user and greets them according to time of day

The application uses the user's ID to connect their workouts and workout logs
to their account.

### User-Specific Workouts

Users can create and view their own workout plans. The application retrieves
the workouts belonging to the logged-in user from the database.

Users can:

- Create a workout
- View saved workouts
- Edit a workout
- Delete a workout


### Unique Workout Names

A user cannot create two workouts with the same name.

The application checks the existing workouts belonging to that user before
creating or updating a workout.

Different users can still have workouts with the same name.

### Workout Logger

Users can select one of their saved workouts and record a completed workout.

The user can enter:

- Workout date
- Duration
- Notes

The completed workout is saved in the MySQL database and can be viewed later.

### Workout History

Users can retrieve their saved workout logs and view their previous sessions.

The history displays:

- Workout name
- Workout date
- Duration
- Notes

### Editing Saved Workout Logs

Users can edit an existing workout log from the Workout History section.

The saved information is loaded into the Workout Logger, where the user can
change the workout, date, duration or notes.

The updated information is sent to the Spring Boot backend and saved to the
database.

### Deleting Saved Workout Logs

Users can delete a saved workout log from Workout History.

After confirmation, the log is deleted from the database and the history is
refreshed to show the updated information.

## Input Validation

The application performs validation before saving data.

Examples include:

- Workout names cannot be empty.
- Target muscle cannot be empty.
- Exercises cannot be empty.
- Sets must be greater than zero.
- Reps must be greater than zero.
- Workout dates are required when creating a workout log.
- Workout duration must be greater than zero.
- A workout must be selected when creating a workout log.
- Workout names must be unique for each user.

### Frontend and Backend Communication

The frontend uses JavaScript and the Fetch API to communicate with the Spring
Boot REST API.

The application uses different HTTP methods depending on the action:

- `GET` - retrieve saved data
- `POST` - create new data
- `PUT` - update existing data
- `DELETE` - remove data

This allows the user interface to interact with the stored data without
having to manually change the database.

### Database Persistence

Workout plans and workout logs are stored in MySQL.

This means that information is not only displayed temporarily on the webpage.
When a user refreshes the page or returns to the application, their saved
data can be retrieved from the database.

### Responsive Interaction

The application also responds to different screen sizes. The desktop and
mobile layouts use responsive CSS so that navigation, forms and workout cards
remain usable on smaller screens.

### Prerequisites

Before running RepMaster, make sure the following are installed:
- Java JDK 21
- MySQL Server
- MySQL Workbench
- IntelliJ IDEA or another Java IDE
- Git
The application uses Java 21 and Spring Boot.

## Database Setup

RepMaster uses MySQL to store users, workout plans and workout logs.
1. Start MySQL Server.
2. Open MySQL Workbench.
3. Create the database used by the application:



## Running the Application

### Using IntelliJ IDEA

1. Clone or download the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java 21 is selected as the project SDK.
4. Make sure MySQL Server is running.
5. Check the database connection in `application.properties`.
6. Run `RepMasterApplication.java`.
7. Open the application in a browser.

The application is available at:

`http://localhost:8080`
## Application Structure

## Backend Structure

The backend follows a layered Spring Boot structure:

- **Controller** – receives HTTP requests from the frontend.
- **Service** – contains validation and application logic.
- **Repository** – communicates with the MySQL database through Spring Data JPA.
- **Entity** – represents database objects such as users, workouts and workout logs.
- **DTO** – transfers data between the frontend and backend.

Example request flow:

```text
Frontend
   |
   | HTTP requests / JSON
   v
Spring Boot REST API
   |
   +-- Controller
   |
   +-- Service
   |
   +-- Repository
   |
   +-- Entity / DTO
   |
   v
MySQL Database

## Backend Structure

The backend follows a layered Spring Boot structure:

- **Controller** – receives HTTP requests from the frontend.
- **Service** – contains validation and application logic.
- **Repository** – communicates with the MySQL database through Spring Data JPA.
- **Entity** – represents database objects such as users, workouts and workout logs.
- **DTO** – transfers data between the frontend and backend.

Example request flow:

Browser → Controller → Service → Repository → MySQL
